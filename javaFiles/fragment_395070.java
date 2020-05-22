public void replace(final FilterBypass fb, final int offs, final int length, final String str, final AttributeSet a)
{
    if (str.equals("\"))
        super.replace(fb, ofs, length, "&#92", a);
    else
        super.replace(fb, offs, length, str, a);
}