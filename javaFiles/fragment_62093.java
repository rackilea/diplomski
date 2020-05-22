String x = "//RecyclerView/RelativeLayout/RelativeLayout/TextView";
String y = "//RecyclerView/RelativeLayout/RelativeLayout";

Android driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

Arraylist<MobileElements> arrayTextViews = driver.findElementsByXpath(x);
Arraylist<MobileElements> arrayParentElements = driver.findElementsByXpath(y);

for(int i = 0; i < arrayTextViews.size(); i++){
    if(arrayTextViews.get(i).getText().equals("text I want")){
        arrayParentElements.get(i).click();
    }
}