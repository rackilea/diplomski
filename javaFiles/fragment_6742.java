ObservableList<MediaFile> items = listView.getItems();
items.forEach(mediaFile) -> {
    //Custom logic... 
    if (mediaFile.equals(currentMediaFile)) {
    ...
    }
});