This project depends on native code. The native code is included in
src/main/native but it is not built currently, as the security
manager in EvoSuite would prohibit native code anyway.


Setup:

First download a ZIP of the repository (this should be called "tmatthe4-master.zip"). Decompress the .zip file, and then open Eclipse. In Eclipse, select "Import" > "General" > "Existing Projects into Workspace." Locate the decompressed "tmatthe4-master" folder and select it, then Finish.
![Importing project](images/Image1.png?raw=true)
JUnit and Maven requirements are included in the package, and the project has already been compiled as a Maven project so little change should be necessary. However, it may be required to update the Maven build in order to compile the machine-dependent native code (I compiled it on a Mac, so if running on another Mac this should be unnecessary in theory). How to do this is shown below:
![Running tests](images/Image2.png?raw=true)
To run the tests, simply right click the project source folder and an select "Coverage as" > "JUnit Test" like below to run the written tests (excluding EvoSuite).
![Running tests](images/Image3.png?raw=true)
At this point in time, the final test results should resemble this:
![Results](images/Image4.png?raw=true)


Artifacts:

The primary artifact is on [SourceForge](http://jni-inchi.sourceforge.net). From this, we can see that JNI-InChI integrates the Java Native Interface (JNI) with the International Chemical Indentifier (InChI) C library. It is intended to be used by other developers to integrate into their projects, and it can generate text identifiers (InChIs) to classify molecules represented with JniInchiInput objects. The original C library's functionality is accessed through the JniInchiWrapper class (source code located at src/main/java/net.sf.jniinchi/JniInchiWrapper.java).


Initial Analysis:

EclEmma indicated 90.8% code coverage from the written tests. This indicates that the written test base is already very solid. However, while most classes had test coverage in the 80-90% range, JniInchiWrapper, which documentation points to as one of the most important classes, only has 76.5% net coverage, which leaves room for improvement. Most of Pitest's mutations, (over 25%), were inside the JniInchiWrapper class. CodeMR's results showed that by most metrics the JniInchiWrapper class is the most integral. It has the most lines of any class, and it has the highest coupling and complexity metrics. Despite this, it does not seem to suffer a significant lack of cohesion, which implies it is well designed. By CodeMR's metrics, most classes across the board appear to measure decently across metrics, with no "problematic" classes, but complexity is the is apparent as the metric classes relatively struggle the most with.

The most important part of the program is clearly the JniInchiWrapper class. It's what integrates the rest of the program to the C library it adapts. Both the documentation and testing metrics results support this.


Test Plan:

Because most of the actual functionality of this program is performed in the InChI C library, the our tests will likely have to focus on more "surface" level matters. This is because the actual Java code mostly just handles integration. Two scenarios to test that focus on the JniInchiWrapper class are proposed below:

The first scenario is if the program is run on a Windows machine. In this case, JniInchiWrapper requires a unique switch character for passing options. We do not run on a Windows machine, but we can manually set the IS_WINDOWS flag to True to test this scenario. This scenario was chosen because current tests to not cover it.
![Results](images/Image5.png?raw=true)

The second scenario to test is if Inchi returns an unknown status. When this happens, the upper Java level must throw an exception. This behavior in the checkInchi method is not covered, but it is important to confirm that the exception works properly. Both ret and retStatus variables can be set for tests.
![Results](images/Image6.png?raw=true)