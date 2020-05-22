@Override
public Dimension getPreferredSize() {
    if (isPreferredSizeSet()) {
        return super.getPreferredSize();
    }
    return new Dimension(PREF_W, PREF_H);
}