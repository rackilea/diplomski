public class ClassB {
    @Test(priority = 0, enabled = true)
    public void class2Test() throws InterruptedException {
        System.out.println("classBTest");
        Init.getDriver().findElement(By.name("q")).sendKeys("Class 2");
    }
}