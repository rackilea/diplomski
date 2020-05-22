GC gc = new GC(text);
try
{
    gc.setFont(text.getFont());
    FontMetrics fm = gc.getFontMetrics();

    /* Set the height to 5 rows of characters */
    data.heightHint = 5 * fm.getHeight();
}
finally
{
    gc.dispose();
}