public void setMaxWidth(int maxWidth) {
    int old = this.maxWidth;
    this.maxWidth = Math.max(minWidth, maxWidth);
    if (width > this.maxWidth) {
        setWidth(this.maxWidth);
    }
    if (preferredWidth > this.maxWidth) {
        setPreferredWidth(this.maxWidth);
    }
    firePropertyChange("maxWidth", old, this.maxWidth);
}