private void refreshList() {
    for (int i = 0; i < lv.getCount(); i++) {
        boolean selected = getSelectedState(i);
        ((View)lv.getItemAtPosition(i)).setBackgroundColor(selected ? Color.GREEN : Color.RED); // Change colors to whatever you need.
    }
}