public static Font loadFont(String path, float size){   
        try {
            InputStream fileStream = Fonts.class.getResourceAsStream(path);
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, fileStream);
            return myFont.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }