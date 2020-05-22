Label label = new Label(...) {
  @Override
  public boolean isVisible() {
    return !hide;
  }
};
form.add(...)
...