driver.get("http://www.google.com");    
          Robot r = new Robot();        
          r.keyPress(KeyEvent.VK_CONTROL);
          r.keyPress(KeyEvent.VK_T);
          r.keyRelease(KeyEvent.VK_CONTROL);
          r.keyRelease(KeyEvent.VK_T);
          driver.get("http://www.facebook.com");