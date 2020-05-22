private void addElement() {
    WordListItem newItem = new WordListItem(-1, "");

    wordListItems.add(newItem);
    wordListView.setEditable(true);

    wordListView.layout();

    wordListView.edit(wordListItems.size()-1);
    wordListView.setEditable(false);
}