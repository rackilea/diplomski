package test;

import org.testng.annotations.BeforeMethod;

public interface ITest {

    @BeforeMethod
    default void beforeDefaultInterface() {
        System.out.println("before from default interface method");
    }
    @BeforeMethod
    static void beforeStaticInterface() {
        System.out.println("before from static interface method");
    }
}