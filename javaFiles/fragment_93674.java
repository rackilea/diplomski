Control [] children = composite.getChildren();

for (Control child : children) {
  if (child instanceof Button && !child.isDisposed()) {
    child.dispose();
  }
}