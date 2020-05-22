@FXML
    private void handleAddNewItem(ActionEvent event) throws IOException {
        boolean flag = mNewBox.display();
        if(flag==true){
            refreshListView();
        }
    }

    public void refreshListView() {
        List<String> list = new ArrayList<String>();
        list = singleton.getFiles();

        items = FXCollections.observableArrayList(list);
        itemsListView.setItems(items);
    }