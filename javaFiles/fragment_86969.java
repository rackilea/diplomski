static class ConnectionsCellFactory extends ListCell<dataObj> {

    @Override
    public void updateItem(dataObj item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item.getConenctionname());
        }
    }
}