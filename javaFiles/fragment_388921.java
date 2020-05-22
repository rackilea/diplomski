package org.test.stackoverflow;

import java.util.List;

import org.junit.runner.RunWith;
import org.junit.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(org.test.stackoverflow.StaticUtil.class)
public class StaticUtilTest {
  Object[] someObjectArray;
  String[] someStringArray;
  boolean aBoolean;
  List<String> someList;
  List<String> anotherList;

  @Test
  public void testWhenClassStringMethod() throws Exception {
    System.out.println("Beginning Test when(Class klass, String method name).doReturn(result)");
    PowerMockito.spy(StaticUtil.class);
    PowerMockito.when(StaticUtil.class, "getSomethingMethod", someObjectArray, someStringArray, aBoolean, someList).thenReturn(anotherList);
    System.out.println("End Test when");
  }

  @Test
  public void testDoReturnActualMethod() throws Exception {
    PowerMockito.spy(StaticUtil.class);
    // This doesn't compile as you've correctly stated
//    PowerMockito.doReturn(anotherList).when(StaticUtil.getSomethingMethod(someObjectArray, someStringArray, aBoolean, someList);
  }

  @Test
  public void testDoReturnClassStringMethod() throws Exception {
    System.out.println("Beginning Test doReturn().when(Class klass, String method name");
    PowerMockito.spy(StaticUtil.class);
    PowerMockito.doReturn(anotherList).when(StaticUtil.class, "getSomethingMethod", someObjectArray, someStringArray, aBoolean, someList);
    System.out.println("End Test doReturn");
  }
}