public class HistoryField extends ComboBox<String> {

    private final static int DEFAULT_MAX_ENTRIES = 5;

    //Data members
    private int maxSize;
    private final ObservableList<String> history;

    //Default constructor
    public HistoryField() {
        this(DEFAULT_MAX_ENTRIES, null);
    }

    /* Changed parameter to an array instead of list of Strings */
    public HistoryField(int maxSize, String[] entries) {
        this.setEditable(true);

        this.maxSize = maxSize;

        /* Convert the passed array to a list and populate the dropdown */
        if (entries != null) {
            history = FXCollections.observableArrayList(Arrays.asList(entries));
        } else {
            history = FXCollections.observableArrayList();
        }

        setItems(history);

        this.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {

                // Check if value already exists in list
                if (!this.history.contains(newValue)) {
                    this.history.add(0, newValue);

                    // If the max_size has been reached, remove the oldest item from the list
                    if (this.history.size() > maxSize) {
                        this.history.remove(history.size() - 1);
                    }

                    System.out.println(history);

                    // Clear the selection when new item is added
                    this.getSelectionModel().clearSelection();
                }
            }
        });
    }
}