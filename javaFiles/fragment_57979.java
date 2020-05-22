Color fxColor = colorGrid.get(x).get(y);
java.awt.Color awtColor = new java.awt.Color((float) fxColor.getRed(),
        (float) fxColor.getGreen(),
        (float) fxColor.getBlue(),
        (float) fxColor.getOpacity());
buffImage.setRGB(x, y, awtColor.getRGB());