public ModuleChooserRootPane() {
    ...
    //this.getChildren().add(rootContainer);
    setLeft(rootContainer);         // or Top/Bottom/Right/Center 


    TabPane tabPane = new TabPane();
    Tab tab = new Tab("Testing");
    tabPane.getTabs().add(tab);
    setCenter(tabPane);             // or Top/Bottom/Right/Left

}