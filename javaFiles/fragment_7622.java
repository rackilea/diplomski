public class ClassA {
    @Test(priority = 0, enabled = true)
    public void classATest() throws InterruptedException {
        System.out.println("classATest");
        Init.getDriver().findElement(By.name("q")).sendKeys("Class 1");
    }
}