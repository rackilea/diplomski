public static Component findComponentUnderGlassPaneAt(Point p, Component top) {
    Component c = null;

    if (top.isShowing()) {
      if (top instanceof RootPaneContainer)
        c =
        ((RootPaneContainer) top).getLayeredPane().findComponentAt(
            SwingUtilities.convertPoint(top, p, ((RootPaneContainer) top).getLayeredPane()));
      else
        c = ((Container) top).findComponentAt(p);
    }

    return c;
  }