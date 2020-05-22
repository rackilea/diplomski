public class FilterComboBox<T> extends ComboBox<T> {

    private final ObservableList<T> items;
    private final ObservableList<T> filter;
    private String s;
    private Object selection;

    private class KeyHandler implements EventHandler<KeyEvent> {

        private SingleSelectionModel<T> sm;

        public KeyHandler() {
            sm = getSelectionModel();
            s = "";
            System.err.println("Initialized keyhandler");
        }

        @Override
        public void handle(KeyEvent event) {
            filter.clear();
            // handle non alphanumeric keys like backspace, delete etc
            if (event.getCode() == KeyCode.BACK_SPACE && s.length() > 0) {
                s = s.substring(0, s.length() - 1);
            } else {
                s += event.getText();
            }

            if (s.length() == 0) {
                setItems(items);
                sm.selectFirst();
                return;
            }
            //System.out.println(s);
            if (event.getCode().isLetterKey()) {
                for (T item : items) {
                    if (item.toString().toUpperCase().startsWith(s.toUpperCase())) {

                        filter.add(item);
                        System.out.println(item);

                        setItems(filter);

                        //sm.clearSelection();
                        //sm.select(item);
                    }
                }
                sm.select(0);
            }

        }
    }

    public FilterComboBox() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FilterComboBox.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        items = getItems();
        this.filter = FXCollections.observableArrayList();

        setOnKeyReleased(new KeyHandler());

        this.focusedProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if ((boolean) newValue == false) {
                    s = "";
                    setItems(items);
                    getSelectionModel().select((T) selection);
                }
            }
        });

        this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    selection = (Object) newValue;
                }
            }
        });
    }

}