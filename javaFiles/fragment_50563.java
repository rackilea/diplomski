try {
    driver.findElement(By.cssSelector("label[for='edit-submitted-name']:not(.error)"))
    System.out.println("Validation okay");
}
catch (NoSuchElementException e) {
    System.out.println("Validation down");
}