WebDriverWait wait = new WebDriverWait(driver, 300);
//check visibility of only headers
By header_locator = By.cssSelector("table#scheduleTable>thead>tr>th");
wait.until(ExpectedConditions.visibilityOfElementLocated(header_locator));
//make sure schedules are not present
By schedule_locator = By.cssSelector("table#scheduleTable>tbody>tr");
wait.until(ExpectedConditions.invisibilityOfElementLocated(schedule_locator));

//now click on Load Schedule Button and make sure schedule appear

wait.until(ExpectedConditions.visibilityOfElementLocated(schedule_locator));