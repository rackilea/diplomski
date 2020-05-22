comboBox.setUI( new WindowsComboBoxUI()
{
    @Override
    protected LayoutManager createLayoutManager()
    {
        return new BasicComboBoxUI.ComboBoxLayoutManager()
        {
            public void layoutContainer(Container parent)
            {
                super.layoutContainer(parent);

                System.out.println(editor.getBounds());
                System.out.println(arrowButton.getBounds());

//              if (XPStyle.getXP() != null && arrowButton != null)
//              {
                    Dimension d = parent.getSize();
                    Insets insets = getInsets();
                    int buttonWidth = arrowButton.getPreferredSize().width;
                    boolean isLeftToRight = parent.getComponentOrientation().isLeftToRight();

                    arrowButton.setBounds(isLeftToRight
                    ? (d.width - insets.right - buttonWidth)
                    : insets.left, insets.top, buttonWidth, d.height - insets.top - insets.bottom);

                    System.out.println(editor.getBounds());
                    System.out.println(arrowButton.getBounds());

                    Dimension size = editor.getSize();
                    editor.setSize(arrowButton.getLocation().x - 1, size.height);
//              }

            }
        };
    }
});