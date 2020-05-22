ListView<Employee> listView = new ListView<>();
listView.setCellFactory(new Callback<ListView<Employee>, ListCell<Employee>>() {
    @Override
    public ListCell<Employee> call(ListView<Employee> param) {
        return new ListCell<Employee>() {

            private ImageView imageView = new ImageView("ImageURL");
            private TextField textField = new TextField("Text");
            private Button button = new Button("Button");
            private BorderPane bp = new BorderPane(imageView, null, button, null, textField);

            @Override
            protected void updateItem(Employee item, boolean empty) {
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getName());
                    setGraphic(bp);
                }
            }
        };
    }
});