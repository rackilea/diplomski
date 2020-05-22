label.setText(text + n++);
// revalidate, but do so synchronously.
Container validateRoot = label;
while (! validateRoot.isValidateRoot()) {
    Container parent = validateRoot.getParent();
    if (parent == null)
        break;
    validateRoot = parent;
}
// This first validate() call may be excluded if the width is already correct
validateRoot.validate();
NoopGraphics g = new NoopGraphics(0, 0, label.getWidth(), label.getHeight(), label.getGraphicsConfiguration(), false, false);
label.paint(g);
validateRoot.validate();
// Now you can use the measured bounds for e.g. scrollRectToVisible