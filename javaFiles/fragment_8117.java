add(new ListView<Map<String,MyObject>>("contentlist", data) {
  protected void populateItem(ListItem<Map<String,MyObject>> item) {
    final Map<String,MyObject> map = item.getModelObject();
    // Inner list - using item.add to add to the inner list
    item.add(new ListView<String>("column", keys) {
      protected void populateItem(ListItem<String> item) {
        String key = item.getModelObject();
        item.add(new Label("data", map.get(key).toString()));
      }
    });
  }
});