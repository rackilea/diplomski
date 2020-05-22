List<WebElement> elements = driver.findElements(By.class("link"));

Random r = new Random();
int random_number = r.nextInt(elements.size()); 

System.out.println("random link " + elements.get(random_number));