if (jpanelDarkGray.getHeight() != jpanelLightGray.getHeight()) {
  if (jpanelMidSep.getHeight() == 8) {
    jpanelMidSep.setPreferredSize(new Dimension(jpanelMidSep.getWidth(), 9));
  }
  if (jpanelMidSep.getHeight() == 9) {
    jpanelMidSep.setPreferredSize(new Dimension(jpanelMidSep.getWidth(), 8));
  }
}