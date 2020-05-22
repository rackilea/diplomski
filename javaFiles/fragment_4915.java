public final class ConversationCell<Message> extends ListCell<Message> { 

    @Override
    protected void updateItem(Message item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            // did you mean to pass null here, or item??
            ConversationCellController ccc = new ConversationCellController(null);
            setGraphic(ccc.getView());
        }
    }
}