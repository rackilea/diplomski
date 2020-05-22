String headline = driver.findElement(By.cssSelector("#center-2 .headline")).getText();
System.out.println(headline);

String link = driver.findElement(By.cssSelector("#center-2 .link")).getText();
System.out.println(link);

String body = driver.findElement(By.cssSelector("#center-2 .body")).getText();
System.out.println(body);