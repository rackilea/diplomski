@Override
public void start(Stage primaryStage) {
    Button btn = new Button();
    btn.setText("Save to file.");
    btn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            FileChooser fc = new FileChooser();
            FileChooser.ExtensionFilter xmlfilter = new FileChooser.ExtensionFilter("XML", "*.xml");
            FileChooser.ExtensionFilter mffilter = new FileChooser.ExtensionFilter("mf", "*.mf");
            fc.getExtensionFilters().addAll(xmlfilter,mffilter);
            fc.setSelectedExtensionFilter(xmlfilter);
            File f = fc.showSaveDialog(primaryStage.getOwner());
            System.out.println("f = " + f);
            if(null == f) {
                return;
            }
            final String selected_description = fc.getSelectedExtensionFilter().getDescription();
            System.out.println("selected_description = " + selected_description);          
            if(selected_description.equals(xmlfilter.getDescription()) && !f.getName().endsWith(".xml")) {
                f = new File(f.getParent(),f.getName()+".xml"); 
            } else if(selected_description.equals(mffilter.getDescription()) && !f.getName().endsWith(".mf")) {
                f = new File(f.getParent(),f.getName()+".mf");
            }
            System.out.println("f = " + f);
        }
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Example");
    primaryStage.setScene(scene);
    primaryStage.show();
}