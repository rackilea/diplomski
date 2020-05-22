private void sortModel(DefaultListModel model) {
    List<MyObject> list = new ArrayList<>();
    for (int i = 0; i < model.size(); i++) {
        list.add((MyObject)model.get(i));
    }
    Collections.sort(list);
    model.removeAllElements();
    for (MyObject s : list) {
        model.addElement(s);
    }
}