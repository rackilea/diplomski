@Listen("onSelect = combobox#mycmb")
public void onComboboxSelected(SelectEvent event) {
  Set<MyObject> selectedObjects = event.getSelectedObjects();
  MyObject obj = selectedObjects.get(0);

  image.setSrc(getImagePath(obj));  // image are Image component you wired.
}