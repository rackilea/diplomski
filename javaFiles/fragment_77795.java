Dimension size = driver.manage().window().getSize();
      Point point = driver.manage().window().getPosition();
      Robot robot = new Robot();
      String format = "png";
      File tempFile = new File(System.getProperty("user.dir") + "//" + screenshotFolder + "//" + fileName);
      Rectangle captureRect = new Rectangle(point.getX(), point.getY(), size.getWidth(), size.getHeight());
      BufferedImage captureImage = robot.createScreenCapture(captureRect);
      ImageIO.write(captureImage, format, tempFile);