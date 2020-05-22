try
    {
        BufferedImage src = ImageIO.read(new File("abc.jpg"));
        int w = src.getWidth();
        int h = src.getHeight();
        source = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Raster raster = src.getRaster().createChild(0, 0, w, h, 0, 0, 
            new int[] {0, 1, 2});
        source.setData(raster);
    }catch(IOException e){System.out.println("Exception Here :"+e);}