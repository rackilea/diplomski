public Dimension getFontSize(FontMetrics metrics ,Font font, String text){
    // get the height of a line of text in this font and render context
    int hgt = metrics.getHeight();
    // get the advance of my text in this font and render context
    int adv = metrics.stringWidth(text);
    // calculate the size of a box to hold the text with some padding.
    Dimension size = new Dimension(adv+2, hgt+2);
    return size;
}

public Font findFont(Component component, Dimension componentSize, Font oldFont, String text){
    //search up to 100
    Font savedFont = oldFont;
    for (int i = 0; i < 100; i++) {
        Font newFont = new Font(oldFont.getFontName(), oldFont.getStyle(), i);
        Dimension d = getFontSize(component.getFontMetrics(newFont),newFont,text);
        if(componentSize.height < d.height || componentSize.width < d.width){
            return savedFont;
        }
        savedFont = newFont;
    }
    return oldFont;
}