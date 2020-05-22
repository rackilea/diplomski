final StyledText text = new StyledText(shell, SWT.NONE);

text.setText("lalala\n\nlalala\n\nlalala\n\nlalala\n\nlalala\n\nlalala\n\n");
text.addLineStyleListener(new LineStyleListener()
{
    @Override
    public void lineGetStyle(LineStyleEvent e)
    {
        // Set the line number
        e.bulletIndex = text.getLineAtOffset(e.lineOffset);

        // Set the style, 12 pixles wide for each digit
        StyleRange style = new StyleRange();
        style.metrics = new GlyphMetrics(0, 0, Integer.toString(text.getLineCount() + 1).length() * 12);

        // Create and set the bullet
        e.bullet = new Bullet(ST.BULLET_NUMBER, style);

        // Apply the offset
        e.bulletIndex += YOUR_OFFSET; // I used 3 here
    }
});