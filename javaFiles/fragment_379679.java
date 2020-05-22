public Dimension getFontSize(Graphics graphics, Font font, String text){
    // get metrics from the graphics
    FontMetrics metrics = graphics.getFontMetrics(font);
    // get the height of a line of text in this font and render context
    int hgt = metrics.getHeight();
    // get the advance of my text in this font and render context
    int adv = metrics.stringWidth(text);
    // calculate the size of a box to hold the text with some padding.
    Dimension size = new Dimension(adv+2, hgt+2);
    return size;
}

public Font findFont(Dimension componentSize, Font oldFont, String text, Graphics g){
    //search up to 100
    Font savedFont = oldFont;
    for (int i = 0; i < 100; i++) {
        Font newFont = new Font(oldFont.getFontName(), oldFont.getStyle(), i);
        Dimension d = getFontSize(g,newFont,text);
        if(componentSize.height < d.height || componentSize.width < d.width){
            return savedFont;
        }
        savedFont = newFont;
    }
    return oldFont;
}