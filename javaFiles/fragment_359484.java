protected void applyFilters(Store<M> store) {
  if (getRawValue().length() > 0) {
    store.addFilter(filter);
    store.applyFilters(property);
  } else {
    store.removeFilter(filter);
  }
}