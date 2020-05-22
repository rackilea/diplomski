public void onMove() {
  if (addedToViewList && !insideScreenView()) {
    this.addedToViewList = false;
    (view list).remove(this);
  }
  else if (!addedToViewList && insideScreenView()) {
    this.addedToViewList = true;
    (view list).add(this);
  }
}