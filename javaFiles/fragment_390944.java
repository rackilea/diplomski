JTextPane textPane = new JTextPane()
{
    public boolean getScrollableTracksViewportWidth()
    {
        return getParent().getSize().width > 100;
    }
};