public class MyController {

    private WidgetDAO widgetAccessor ;

    // java.util.concurrent.Executor typically provides a pool of threads...
    private Executor exec ;

    @FXML
    private TextField widgetTypeSearchField ;

    @FXML
    private TableView<Widget> widgetTable ;

    public void initialize() throws Exception {
        widgetAccessor = new WidgetDAO();

        // create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t ;
        });
    }

    // handle search button:
    @FXML
    public void searchWidgets() {
        final String searchString = widgetTypeSearchField.getText();
        Task<List<Widget>> widgetSearchTask = new Task<List<Widget>>() {
            @Override
            public List<Widget> call() throws Exception {
                return widgetAccessor.getWidgetsByType(searchString);
            }
        };

        widgetSearchTask.setOnFailed(e -> {
           widgetSearchTask.getException().printStackTrace();
            // inform user of error...
        });

        widgetSearchTask.setOnSucceeded(e -> 
            // Task.getValue() gives the value returned from call()...
            widgetTable.getItems().setAll(widgetSearchTask.getValue()));

        // run the task using a thread from the thread pool:
        exec.execute(widgetSearchTask);
    }

    // ...
}