//this code should run once at initialization/application startup
FontFactory.register("resources/wingding_font.ttf");
Font textFont = FontFactory.getFont("wingding", BaseFont.IDENTITY_H, 
    BaseFont.EMBEDDED, 10); //10 is the size
...
//reuse the reference to the font object when rendering your text
Paragraph p = new Paragraph("someText", textFont);