Button btn = new Button();
btn.addListener(new ClickListener() {
    if (selectedVector != null) {
      VectorLayer vl = (VectorLayer) selectedVector.getParent();
      vl.setSelectedVector(null);
    }
});