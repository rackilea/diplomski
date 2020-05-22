@Override
public Dimension getPreferredSize() {
    Dimension superSize = super.getPreferredSize();
    if (isPreferredSizeSet() || img == null) {
        return superSize;
    }
    int supW = superSize.width;
    int supH = superSize.height;
    int imgW = img.getWidth();
    int imgH = img.getHeight();
    int w = Math.max(imgW, supW);
    int h = Math.max(imgH, supH);
    return new Dimension(w, h);
}