try {
    driver.findElement(By.xpath("//label[@for='edit-submitted-name' and not(@class='error')]"))
    System.out.println("Validation okay");
}
catch (NoSuchElementException e) {
    System.out.println("Validation down");
}