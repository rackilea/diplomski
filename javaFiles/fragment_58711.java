public GameFont(String filename, int fontSize){
        try{
            File fontFile = new File(filename);
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            font.deriveFont(fontSize);
        }catch(FontFormatException | IOException e){
        }
    }