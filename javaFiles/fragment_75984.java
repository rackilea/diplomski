int color1 = 0xffFF00FF;
    int color2 = 0x00FFFFFF;

    Color c1 = new Color(color1, true);
    Color c2 = new Color(color2, true);
    int a1 = c1.getAlpha();
    int a2 = c2.getAlpha();

    Color result = new Color((c1.getRed() * a1 + c2.getRed() * a2) / (a1 + a2),
            (c1.getGreen() * a1 + c2.getGreen() * a2) / (a1 + a2),
            (c1.getBlue() * a1 + c2.getBlue() * a2) / (a1 + a2),
            (c1.getAlpha() + c2.getAlpha()) / 2);
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(result);