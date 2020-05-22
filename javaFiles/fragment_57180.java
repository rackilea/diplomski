@Override
public Dimension getPreferredSize() {
    // comply to contract if set
    if(isPreferredSizeSet())
        return super.getPreferredSize();
    // do whatever we want
    return new Dimension(dim);
}