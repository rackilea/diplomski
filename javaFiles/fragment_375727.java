protected void reflow() {
    Composite c = this;
    while (c != null) {
        c.setRedraw(false);
        c = c.getParent();
        if (c instanceof SharedScrolledComposite || c instanceof Shell) {
            break;
        }
    }
    c = this;
    while (c != null) {
        c.layout(true);
        c = c.getParent();
        if (c instanceof SharedScrolledComposite) {
            ((SharedScrolledComposite) c).reflow(true);
            break;
        }
    }
    c = this;
    while (c != null) {
        c.setRedraw(true);
        c = c.getParent();
        if (c instanceof SharedScrolledComposite || c instanceof Shell) {
            break;
        }
    }
}