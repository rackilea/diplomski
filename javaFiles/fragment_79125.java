try {
  while (true)
  {
    driver.findElement(By.xpath("//span[text()='Followed']")).click();
  }
} catch (ElementNotFoundException ex) {
  driver.findElement(By.xpath("//span[text()='Next Page']")).click()
}