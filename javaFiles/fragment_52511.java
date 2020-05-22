package sample.testng;
import org.testng.annotations.Test;
import org.testng.Assert;


public class SampleTest {

@Test
public void test(){
    System.out.println("Executing test 1");
    Assert.assertEquals("ABCD", "abc");
}


@Test(dependsOnMethods={"test"})
public void test1(){
    System.out.println("Second test runs only if the first one is successful, otherwise its ignored");
    //Asserts or whatever
}

}