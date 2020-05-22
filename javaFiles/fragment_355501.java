public void updateFilters() {
  if (cb.isSelected()) {
    if (tf.getText().length() > 0) {
       // Both filters active so construct an and filter.
       sorter.setRowFilter(RowFilter.andFilter(bookFilter, checkBoxFilter));
    } else {
       // Checkbox selected but text field empty.
       sorter.setRowFilter(checkBoxFilter);
    }
  } else if (tf.getText().length() > 0) {
    // Checkbox deselected but text field non-empty.
    sorter.setRowFilter(bookFilter);
  } else {
    // Neither filter "active" so remove filter from sorter.
    sorter.setRowFilter(null); // Will cause table to re-filter.
  }
}