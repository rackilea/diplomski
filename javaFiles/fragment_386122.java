list.setCellFactory(lv -> new ListCell<WordType>() {

    private final TextField word = new TextField();
    private final TextField translate = new TextField();
    private final ToolBar root = new ToolBar(word, new Separator(), translate);

    {
        // anonymous constructor:

        word.textProperty().addListener((obs, oldText, newText) -> {
            WordType wordType = getItem();
            wordType.setFirst(newText);
        });

        translate.textProperty().addListener((obs, oldText, newText) -> {
            WordType wordType = getItem();
            wordType.setSecond(newText);
        });
    }

    @Override
    protected void updateItem(WordType item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(empty ? null : root);
    }
});