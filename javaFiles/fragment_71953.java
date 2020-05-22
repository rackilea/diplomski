public void runTests(){
   ...create your drivers here (and the array)...
   for (WebDriver driver: drivers){
      runFirstTest(driver);
      runSecondTest(driver);
   }
}

public void runFirstTest(driver){
    ...code using driver goes here....
}