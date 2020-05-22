public class Page1Steps {

    public void testMethod() {
        Page1 pageOne = new Page1(driver);
        pageOne
            .completePageAndGoToPageTwo()
            .completePageTwo();
    }
}