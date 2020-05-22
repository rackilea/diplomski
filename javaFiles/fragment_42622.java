driver.get("http://www.amazon.in/");

    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bagsasdfafds");

    int count = driver.findElements(By.className("suggest_link")).size();

    Assert.assertTrue(count>=1);
    System.out.println("Count is greater than or equal to 1. Count is: "+count);//This line will ONLY be printed if the count is greater than or equal to 1.