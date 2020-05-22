Callback<TableColumn<Inventory, String>, TableCell<Inventory, String>> cellFactory =
        new Callback<TableColumn<Inventory, String>, TableCell<Inventory, String>>() {
            public TableCell call(TableColumn p) {
                TableCell cell = new TableCell<Person, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : getString());
                        setStyle("-fx-background-color:"+getString());
                    }

                    private String getString() {
                        return getItem() == null ? "" : getItem().toString();
                    }
                };


                return cell;
            }
        };