/*
 * This file was automatically generated by EvoSuite
 */

package net.sf.jniinchi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import net.sf.jniinchi.INCHI_KEY;
import org.junit.BeforeClass;

@RunWith(EvoSuiteRunner.class)
public class TestINCHI_KEY {

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = true; 
  } 


  @Test
  public void test0()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.NOT_ENOUGH_MEMORY;
      int int0 = iNCHI_KEY0.getIndx();
      assertEquals(4, int0);
  }

  @Test
  public void test1()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(0);
      assertEquals(INCHI_KEY.OK, iNCHI_KEY0);
  }

  @Test
  public void test2()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(4);
      assertEquals(INCHI_KEY.NOT_ENOUGH_MEMORY, iNCHI_KEY0);
  }

  @Test
  public void test3()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(1);
      assertEquals(INCHI_KEY.UNKNOWN_ERROR, iNCHI_KEY0);
  }

  @Test
  public void test4()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(2);
      assertEquals(INCHI_KEY.EMPTY_INPUT, iNCHI_KEY0);
  }

  @Test
  public void test5()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(3);
      assertEquals(INCHI_KEY.INVALID_INCHI_PREFIX, iNCHI_KEY0);
  }

  @Test
  public void test6()  throws Throwable  {
      INCHI_KEY.getValue(5);
  }

  @Test
  public void test7()  throws Throwable  {
      INCHI_KEY.getValue(6);
  }

  @Test
  public void test8()  throws Throwable  {
      INCHI_KEY.getValue(7);
  }

  @Test
  public void test9()  throws Throwable  {
      INCHI_KEY.getValue(8);
  }

  @Test
  public void test10()  throws Throwable  {
      INCHI_KEY.getValue(9);
  }

  @Test
  public void test11()  throws Throwable  {
      INCHI_KEY.getValue(10);
  }

  @Test
  public void test12()  throws Throwable  {
      INCHI_KEY.getValue(11);
  }

  @Test
  public void test13()  throws Throwable  {
      INCHI_KEY.getValue(12);
  }

  @Test
  public void test14()  throws Throwable  {
      INCHI_KEY.getValue(13);
  }

  @Test
  public void test15()  throws Throwable  {
      INCHI_KEY.getValue(14);
  }

  @Test
  public void test16()  throws Throwable  {
      INCHI_KEY.getValue(15);
  }

  @Test
  public void test17()  throws Throwable  {
      INCHI_KEY.getValue(16);
  }

  @Test
  public void test18()  throws Throwable  {
      INCHI_KEY.getValue(17);
  }

  @Test
  public void test19()  throws Throwable  {
      INCHI_KEY.getValue(18);
  }

  @Test
  public void test20()  throws Throwable  {
      INCHI_KEY.getValue(19);
  }

  @Test
  public void test21()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(20);
      assertEquals(INCHI_KEY.INVALID_INCHI, iNCHI_KEY0);
  }

  @Test
  public void test22()  throws Throwable  {
      INCHI_KEY iNCHI_KEY0 = INCHI_KEY.getValue(21);
      assertEquals(INCHI_KEY.INVALID_STD_INCHI, iNCHI_KEY0);
  }

  @Test
  public void test23()  throws Throwable  {
      INCHI_KEY.getValue(1268);
  }
}
