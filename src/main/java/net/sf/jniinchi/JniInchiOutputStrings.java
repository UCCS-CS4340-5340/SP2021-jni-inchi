package net.sf.jniinchi;

public class JniInchiOutputStrings {
	public String inchi;
	public String auxInfo;
	public String message;
	public String log;

	public JniInchiOutputStrings(String inchi, String auxInfo, String message, String log) {
		this.inchi = inchi;
		this.auxInfo = auxInfo;
		this.message = message;
		this.log = log;
	}
}