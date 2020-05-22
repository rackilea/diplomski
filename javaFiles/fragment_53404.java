public void enableHighlighting() {
  if (!isHighlighting) {
    isHighlighting = true;
    colorView();  // very expensive method
  }
}