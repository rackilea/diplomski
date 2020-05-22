@Override
public Dimension getPreferredSize() {
    if (getLayout() != null) {
        return getLayout().preferredLayoutSize(this);
    }
    return super.getPreferredSize();
}