//text is your StyledText
text.addLineStyleListener(new LineStyleListener()
{
    public void lineGetStyle(LineStyleEvent e)
    {
        //Set the line number
        e.bulletIndex = text.getLineAtOffset(e.lineOffset);

        //Set the style, 12 pixles wide for each digit
        StyleRange style = new StyleRange();
        style.metrics = new GlyphMetrics(0, 0, Integer.toString(text.getLineCount()+1).length()*12);

        //Create and set the bullet
        e.bullet = new Bullet(ST.BULLET_NUMBER,style);
    }
});