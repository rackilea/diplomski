public SlickTTF(){
    try{
        awtFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        awtFont = awtFont.deriveFont(20f);
        font = new TrueTypeFont(awtFont, true);
    }catch(Exception e){}
}