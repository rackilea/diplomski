yourColumn.setFieldUpdater(new FieldUpdater<T, String>() {
  public void update(int index, T object, String value) {
    if (yourGrid.getKeyboardSelectedRow() != -1 ) {
      if (yourGrid.getKeyboardSelectedSubRow() > 0) {
        // Subrow selected.
      } else {
        // Main row selected.
      }
    }
  }
});