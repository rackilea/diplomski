protected LayoutManager createLayoutManager() {
    return new BasicComboBoxUI.ComboBoxLayoutManager() {
    public void layoutContainer(Container parent) {
    super.layoutContainer(parent);

    if (XPStyle.getXP() != null && arrowButton != null) {
        Dimension d = parent.getSize();
        Insets insets = getInsets();
        int buttonWidth = arrowButton.getPreferredSize().width;
        arrowButton.setBounds(WindowsGraphicsUtils.isLeftToRight((JComboBox)parent)
      ? (d.width - insets.right - buttonWidth)
      : insets.left,
      insets.top,
      buttonWidth, d.height - insets.top - insets.bottom);
    }
    }
};
}