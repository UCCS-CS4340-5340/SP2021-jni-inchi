/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.jniinchi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.jniinchi.INCHI_OPTION;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestINCHI_OPTION {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      INCHI_OPTION.valueOfIgnoreCase("");
  }

  @Test
  public void test1()  throws Throwable  {
      INCHI_OPTION iNCHI_OPTION0 = INCHI_OPTION.valueOfIgnoreCase("SAbs");
      assertEquals(INCHI_OPTION.SAbs, iNCHI_OPTION0);
  }
}