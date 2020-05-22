public final class ConversationCell<Message> extends ListCell<Message> { 

    private final ConversationCellController ccc = new ConversationCellController(null);
    private final Node view = ccc.getView();

    @Override
    protected void updateItem(Message item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            ccc.setItem(item);
            setGraphic(view);
        }
    }
}