Object parent = getParent();
if (parent instanceof PrimaryWrapper) {
  ((PrimaryWrapper) parent).addItem(axisItem);
} else if (parent instanceof SecondaryWrapper) {
  ((SecondaryWrapper) parent).addItem(axisItem);
} else {
  // log error?
}