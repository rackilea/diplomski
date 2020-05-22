JButton button = new JButton("Text on left:")
{
    @Override
    public void doLayout()
    {
        super.doLayout();

        int preferredWidth = getPreferredSize().width;
        int actualWidth = getSize().width;

        if (actualWidth != preferredWidth)
        {
            int gap = getIconTextGap() + actualWidth - preferredWidth;
            gap = Math.max(gap, UIManager.getInt("Button.iconTextGap"));
            setIconTextGap(gap);
        }
    }
};
button.setIcon( new ImageIcon("copy16.gif") );
button.setHorizontalTextPosition(SwingConstants.LEADING);