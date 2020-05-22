JTextPane textArea = new JTextPane()
{
    @Override
    public Dimension getPreferredSize()
    {
        Dimension d = super.getPreferredSize();
        d = (d == null) ? new Dimension(400,400) : d;
        Insets insets = getInsets();

        d.width = Math.max(d.width, 300 + insets.left + insets.right);
        d.height = Math.max(d.height, 300 + insets.top + insets.bottom);

        return d;
    }
};