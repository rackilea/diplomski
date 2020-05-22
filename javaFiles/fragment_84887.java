driver.get("http://docs.seleniumhq.org/");

      int width=driver.findElement(By.tagName("img")).getSize().getWidth();
      int hight=driver.findElement(By.tagName("img")).getSize().getHeight();

      System.out.println(width +">>>"+hight);

      //to verify width
      Assert.assertEquals(width, 200);