javafx.collections.ObservableList a = javafx.collections.FXCollections.observableArrayList();
a.addListener(new javafx.collections.ListChangeListener<String>() {
    @Override
    public void onChanged(Change<? extends String> c) {
        System.out.println(c);
    }});

a.add("aa");
a.add("bb");