BufferedImage image = null;

    try
    {
        image = BMPDecoder.read(new File("C:\\test.bmp"));
    }
    catch(IOException ex)
    {
        Logger.getLogger(DesktopApplication1View.class.getName()).log(Level.SEVERE, null, ex);
    }

    jLabel1.setIcon(new ImageIcon(image));