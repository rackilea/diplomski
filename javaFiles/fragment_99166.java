/* @see javax/swing/plaf/metal/MetalIconFactory.java */
class MenuArrowIcon implements Icon {
  @Override public void paintIcon(Component c, Graphics g, int x, int y) {
    JMenuItem b = (JMenuItem) c;
    ButtonModel model = b.getModel();

    g.translate(x, y);
    if (!model.isEnabled()) {
      g.setColor(MetalLookAndFeel.getMenuDisabledForeground());
    } else {
      if (model.isArmed() || (c instanceof JMenu && model.isSelected())) {
        g.setColor(MetalLookAndFeel.getMenuSelectedForeground());
        // use Color.MAGENTA: g.setColor(UIManager.getColor("Menu.selectedForeground"));
      } else {
        g.setColor(b.getForeground());
      }
    }
    // if (MetalUtils.isLeftToRight(b)) {
      int[] xPoints = {0, 3, 3, 0};
      int[] yPoints = {0, 3, 4, 7};
      g.fillPolygon(xPoints, yPoints, 4);
      g.drawPolygon(xPoints, yPoints, 4);
    // } else {
    //   int[] xPoints = {4, 4, 1, 1};
    //   int[] yPoints = {0, 7, 4, 3};
    //   g.fillPolygon(xPoints, yPoints, 4);
    //   g.drawPolygon(xPoints, yPoints, 4);
    // }
    g.translate(-x, -y);
  }

  @Override public int getIconWidth() {
    return 4;
  }

  @Override public int getIconHeight() {
    return 8;
  }
}