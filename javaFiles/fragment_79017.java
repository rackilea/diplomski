// Plan B Warranty (Taxi) & Breakdown Recovery
WebElement e = driver.findElement(By.cssSelector("input[name='warrantyPlan']"));
System.out.println(e.isSelected()); // false
System.out.println(e.findElement(By.xpath("..")).getText()); // Plan B Warranty (Taxi) & Breakdown Recovery

// Vehicle Asset Protection - Standard Cover
e = driver.findElement(By.cssSelector("input[name='vapPlan']"));
System.out.println(e.isSelected()); // false
System.out.println(e.findElement(By.xpath("..")).getText()); // Vehicle Asset Protection - Standard Cover