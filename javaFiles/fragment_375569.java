WebElement failedElement = driver.findElement(<locate your element>);
File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
final BufferedImage image = ImageIO.read(screenShotFile);
Graphics g = image.getGraphics();
g.setFont(g.getFont().deriveFont(30f));
g.drawString("Failed because of this!!", failedElement.getSize().getX(), failedElement.getSize().getY()); //Top-left coordinates of your failed element
g.dispose();
ImageIO.write(image, "png", new File("test.png"));