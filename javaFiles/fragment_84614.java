Point point = element.getLocation();

int upperY = point.getY();
int lowerY = upperY + element.getSize().getHeight();
int middleY = (upperY + lowerY) / 2;

new TouchAction(((AppiumDriver<MobileElement>) driver)).press(100, middleY).waitAction().release().perform();