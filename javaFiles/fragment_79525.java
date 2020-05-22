TableView<MyDataType> table = new TableView<>();
// set up columns...

Task<List<MyDataType>> loadDataTask = new Task<List<MyDataType>>() {
    @Override
    protected List<MyDataType> call() throws Exception {
        List<MyDataType> data = ... ;
        // load data and populate list ...
        return data ;
    }
};
loadDataTask.setOnSucceeded(e -> table.getItems().setAll(loadDataTask.getValue()));
loadDataTask.setOnFailed(e -> { /* handle errors... */ });

ProgressIndicator progressIndicator = new ProgressIndicator();
table.setPlaceHolder(progressIndicator);

Thread loadDataThread = new Thread(loadDataTask);
loadDataThread.start();