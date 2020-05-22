//enter the appropriate type of image for TYPE_FOO
BufferedImage cropped = new BufferedImage(300, 300, BufferedImage.TYPE_FOO);
cropped.getGraphics().drawImage(image, 
        0, 0, 300, 300, //draw onto the entire 300x300 destination image
        100, 100, 400, 400, //draw the section of the image between (100, 100) and (400, 400)
        null);
image = cropped;