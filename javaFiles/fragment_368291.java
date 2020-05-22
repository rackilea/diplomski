package com.core.java.testing;  

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  

import static org.junit.Assert.*;  

public class RoversOnMarsTest {  

// Method is called before each test case execution  
@Before
public void setUp() throws Exception {

}

// Method is called after each test case execution
@After
public void tearDown() throws Exception {

}

@Test
public void testCommandLettersDefaultConst() throws Exception {
    // default const x=0, y=0 , compass : N
    RoversOnMars roversOnMars = new RoversOnMars();
    roversOnMars.CommandLetters("M");
    assertEquals("Y should be 1", roversOnMars.getY(), 1);
    assertEquals("X should be 1", roversOnMars.getX(), 0);
}

@Test
public void testCommandForWCompass() throws Exception {
    // default const x=0, y=0 , compass : W
    RoversOnMars roversOnMars = new RoversOnMars(23, 23, "W");
    roversOnMars.CommandLetters("M");
    assertEquals("Y should be 23", roversOnMars.getY(), 23);
    assertEquals("X should be 22", roversOnMars.getX(), 22);
   }
 }