final Task<Data> initTask = new Task() {
  @Override protected Data call() throws InterruptedException {
    updateMessage("Initializing Application");
    MyApp.initializeAppContext(); 
    updateMessage("Loading Data");
    Data data = DB.loadData(); 
    updateMessage("Data Loaded");

    return data;
  }

showSplash(initStage, initTask);
new Thread(initTask).start();
showMainStage(initTask.valueProperty());