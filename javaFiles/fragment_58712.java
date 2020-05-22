public GameFont(String filename, float fontSize){
        try{
            File fontFile = new File(filename);
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            font = font.deriveFont(fontSize);
        }catch(FontFormatException | IOException e){ 
           e.printStackTrace(); // ****
        }
    }