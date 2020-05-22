List<WebElement> images = driver.findElements(By.cssSelector("img[src]"));
System.out.println("Total Number of images found on page = " + images.size());
int brokenImagesCount = 0;
for (WebElement image : images)
{
    if (isImageBroken(image))
    {
        brokenImagesCount++;
        System.out.println(image.getAttribute("outerHTML"));
    }
}
System.out.println("Count of broken images: " + brokenImagesCount);
Assert.assertEquals(brokenImagesCount, 0, "Count of broken images is 0");