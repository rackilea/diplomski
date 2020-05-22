driver.findElementByAndroidUIAutomator("UiSelector().text(\"Continue with Facebook\")").click();
      Thread.sleep(2000);
      driver.findElement(By.id("m_login_email")).sendKeys("yourfb id");
      Thread.sleep(2000);
      driver.findElement(By.id("m_login_password")).sendKeys("password");
      Thread.sleep(2000);
      driver.findElement(By.id("u_0_5")).click();