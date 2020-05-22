driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
try {
    driver.findElement(By.id("element_id"));
    System.out.println("Element Found");
} catch (NoSuchElementException e) {
    System.out.println("Element Not Found");
}