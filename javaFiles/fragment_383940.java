public boolean find(DataStruct<T> listItem, T key) {
    if (!(listItem instanceof ListItem)) {
        // decide whether to return false or throw an exception
    }
    ListItem<T> tmpListItem = (ListItem<T>) listItem;
    ...
}