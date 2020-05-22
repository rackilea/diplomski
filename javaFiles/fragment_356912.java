// get all links by xpath
List<WebElement> links = driver.findElements(By.xpath("//*[contains(text(), 'Apply Now')]));

// select a random one
Random gen = new Random();
WebElement link = links.get(gen.nextInt(list.size()));

link.click();