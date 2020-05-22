@Override
public ObservableList<TreeItem<String>> getChildren() {  
    if (hasLoadedChildren == false) {
        Task<ArrayList<LazyTreeItem>> task = new Task<ArrayList<LazyTreeItem>>() {
            @Override
            protected void succeeded() {
                super.succeeded();
                hasLoadedChildren = true;
                LazyTreeItem.super.getChildren().setAll(getValue());
                // remove progress indicator
                setGraphic(null);
            }            
            @Override
            protected ArrayList<LazyTreeItem> call() throws Exception {
                ArrayList<LazyTreeItem> list = loadChildren();
                return list;
            }
        };
        Thread t = new Thread(task);
        // show progress indicator
        setGraphic(pinMain);
        t.start();
    }  
    return super.getChildren();  
}