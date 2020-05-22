final class SquareJTextField extends JTextField {
    private static Dimension maxDimension = new Dimension(0, 0);

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        // take the larger value
        int max = d.width > d.height ? d.width : d.height;
        // compare it against our static dimension
        // height je rovnaky ako width
        if (max > maxDimension.width)
            maxDimension = new Dimension(max, max);
        // return copy so no one can change the private one
        return new Dimension(maxDimension);
    }

    @Override
    public Dimension getMinimumSize() {
        Dimension d = super.getPreferredSize();
        int max = d.width > d.height ? d.width : d.height;
        if (max > maxDimension.width)
            maxDimension = new Dimension(max, max);
        return new Dimension(maxDimension);
    }

    @Override
    public Dimension getMaximumSize() {
        Dimension d = super.getPreferredSize();
        int max = d.width > d.height ? d.width : d.height;
        if (max > maxDimension.width)
            maxDimension = new Dimension(max, max);
        return new Dimension(maxDimension);
    }
}