@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);
    ArrayList<ShelfItem> toSave = new ArrayList<>(shelfItems);
    savedInstanceState.putParcelableArrayList("key", toSave);
}