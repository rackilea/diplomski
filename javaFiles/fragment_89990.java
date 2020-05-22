ByteArrayOutputStream bos=new ByteArrayOutputStream();
    byte[] imageByte = null;
   try
   {
        //To Get the the size of the screen.
        Rectangle screenRect = new Rectangle(Toolkit
                .getDefaultToolkit().getScreenSize());          

        //To Store the scrreen shot in buffer.
        BufferedImage capture = new Robot()
                .createScreenCapture(screenRect);   

        //To Save the image on specific location.
        ImageIO.write(capture, "png",bos);
        bos.flush();
        imageByte=bos.toByteArray();
        bos.close();

         // File file = new File("resources/img/screenshot.png");
        MultipartEntity mpEntity = new MultipartEntity();
      //  ContentBody cfBody = new FileBody(file);
          ContentBody cfBody = new ByteArrayBody(imageByte,"screenshot.png");
        mpEntity.addPart("screenshot", cfBody);