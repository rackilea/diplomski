filterText = new StoreFilterField<ModelData>() {
  @Override
  protected void applyFilters(Store<M> store) {
    if (getRawValue().length() > 3) {
      store.addFilter(filter);
      store.applyFilters(getProperty());
    } else {
      store.removeFilter(filter);
    }
  }
}