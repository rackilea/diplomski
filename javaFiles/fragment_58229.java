public void layoutContainer(Container parent) {
  synchronized (parent.getTreeLock()) {
    Insets insets = parent.getInsets();
    int ncomponents = parent.getComponentCount();
    int nrows = rows;
    int ncols = cols;
    boolean ltr = parent.getComponentOrientation().isLeftToRight();

    if (ncomponents == 0) {
        return;
    }
    if (nrows > 0) {
        ncols = (ncomponents + nrows - 1) / nrows;
    } else {
        nrows = (ncomponents + ncols - 1) / ncols;
    }
    int w = parent.width - (insets.left + insets.right);
    int h = parent.height - (insets.top + insets.bottom);
    w = (w - (ncols - 1) * hgap) / ncols;
    h = (h - (nrows - 1) * vgap) / nrows;

    if (ltr) {
        for (int c = 0, x = insets.left ; c < ncols ; c++, x += w + hgap) {
        for (int r = 0, y = insets.top ; r < nrows ; r++, y += h + vgap) {
            int i = r * ncols + c;
            if (i < ncomponents) {
            parent.getComponent(i).setBounds(x, y, w, h);
            }
        }
        }
    } else {
        for (int c = 0, x = parent.width - insets.right - w; c < ncols ; c++, x -= w + hgap) {
        for (int r = 0, y = insets.top ; r < nrows ; r++, y += h + vgap) {
            int i = r * ncols + c;
            if (i < ncomponents) {
            parent.getComponent(i).setBounds(x, y, w, h);
            }
        }
        }
    }
  }
}