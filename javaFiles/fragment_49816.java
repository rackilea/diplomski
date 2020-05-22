ListView<LogData> listView = new ListView<>();
listView.setCellFactory(cb -> new LogDataCell(){});

public class LogDataCell extends ListCell<LogData>
{
    @Override
    protected void updateItem(LogData item, boolean empty) {
        super.updateItem(item, empty);

        if(empty || item == null) {
            setText(null);
            setGraphic(null);
        }
        else {
            List<String> fragments = item.getHighlightedFragments();
            if(fragments == null || fragments.isEmpty()) {
                setText(item.getLogMessage());
                setGraphic(null);
            }
            else {
                TextFlow textFlow = null; //TODO
                setText(null);
                setGraphic(textFlow);
            }
        }
    }
}