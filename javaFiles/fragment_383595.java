int blueMask = 0xFF0000, greenMask = 0xFF00, redMask = 0xFF;
    int r = 12, g = 13, b = 14;
    int bgrValue = (b << 16) + (g << 8) + r;
    System.out.println("blue:" + ((bgrValue & blueMask) >> 16));
    System.out.println("red:" + ((bgrValue & redMask)));
    System.out.println("green:" + ((bgrValue & greenMask) >> 8));