int w = image.getWidth();
        int h = image.getHeight();

        int[] dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w); 

        int pixX = 25;
        int pixY = 50;

        Color c = new Color(dataBuffInt[pixX+pixY*w]);

        System.out.println(c.getRed());   // = (dataBuffInt[100] >> 16) & 0xFF
        System.out.println(c.getGreen()); // = (dataBuffInt[100] >> 8)  & 0xFF
        System.out.println(c.getBlue());  // = (dataBuffInt[100] >> 0)  & 0xFF
        System.out.println(c.getAlpha()); // = (dataBuffInt[100] >> 24) & 0xFF