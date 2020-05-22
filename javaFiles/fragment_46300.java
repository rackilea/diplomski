public void setMajorTickSpacing(int n) {
    int oldValue = majorTickSpacing;
    majorTickSpacing = n;
    if ( labelTable == null && getMajorTickSpacing() > 0 && getPaintLabels() ) {
        setLabelTable( createStandardLabels( getMajorTickSpacing() ) );
    }
    firePropertyChange("majorTickSpacing", oldValue, majorTickSpacing);
    if (majorTickSpacing != oldValue && getPaintTicks()) {
        repaint();
    }
}