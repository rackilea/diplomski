items.setCellFactory(new Callback<ListView<MediaItem>, ListCell<MediaItem>>() {
    @Override
    public ListCell<MediaItem> call(ListView<MediaItem> param) {
        return new ListCell<MediaItem>() {
            @Override
            protected void updateItem(MediaItem item, boolean empty) {
                super.updateItem(item, empty);
                if(item != null) {
                    setText(item.getTitle());
                }else{
                    setText("");
                }
            }
        };
    }
});