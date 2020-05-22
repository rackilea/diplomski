public void createTabAndList(TabPane tabPane){
    List<String> _list = new ArrayList<String>(); //_list is local now
    for(int i = 0; i < 10000000; i++){
        _list.add("Test Test Test");
    }
    TableView<String> tb1 = new TableView<String>();
    tb1.setItems(FXCollections.observableArrayList(_list));
    Tab tab = new Tab("Tab1");
    tab.setContent(tb1);
    tabPane.getTabs().add(tab);
    tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);        
    //tab.setOnClosed(new EventHandler<Event>() {
    //    @Override
    //    public void handle(Event arg0) {
    //        tb1.setItems(null);
    //        _list.clear();
    //        _list = new ArrayList<String>();
    //    }
    //});
}