package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DummyTest implements ITest {

    @BeforeMethod
    public void beforeTest() {
        System.out.println("before from class");
    }

    @Test
    public void test1() {
        System.out.println("I am test1");
    }
}