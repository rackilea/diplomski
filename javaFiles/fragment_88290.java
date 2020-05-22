ByteArrayInputStream imgbytes = new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
assert imgbytes.available() > 0;
BufferedImage bimg = ImageIO.read(imgbytes);
bimg = bimg.getSubimage(0, 0, 500, 500);
assert bimg.getHeight() > 0;
assert bimg.getWidth() > 0;
File imgfile = new File("screenshot.png");
ImageIO.write(bimg, "png", imgfile);
assert imgfile.length() > 0;