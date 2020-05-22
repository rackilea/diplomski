public class TreeViewSample extends Application {

private int count=0;

private TreeView<String> tree;
public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Tree View Sample");        


    TextField txtField=new TextField();
    Button searchBtn=new Button("Search");

    txtField.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            count=0;
        }
    });
    TreeItem<String> rootItem = new TreeItem<String> ("Root");
    rootItem.setExpanded(true);

    TreeItem<String> item1 = new TreeItem<String> ("Child 1");
    TreeItem<String> item12 = new TreeItem<String> ("Child 12");
    item1.getChildren().add(item12);
    TreeItem<String> item2 = new TreeItem<String> ("Child 2");
    TreeItem<String> item21 = new TreeItem<String> ("Child 21");
    item2.getChildren().add(item21);
    TreeItem<String> item211 = new TreeItem<String> ("Child 12");
    item21.getChildren().add(item211);
    TreeItem<String> item3 = new TreeItem<String> ("Child 3");
    TreeItem<String> item31 = new TreeItem<String> ("Child 12");
    item3.getChildren().add(item31);
    rootItem.getChildren().addAll(item1,item2,item3);
    searchBtn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            count++;
            handleSearch(rootItem,txtField.getText());

        }
    });
    this.tree = new TreeView<String> (rootItem);    

    VBox root = new VBox();
    root.getChildren().addAll(tree,txtField,searchBtn);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
}

protected int handleSearch(TreeItem<String> rootItem, String text) {
    int count=0;
    if(rootItem!=null&&rootItem.getValue().equals(text)){
        tree.getSelectionModel().select(rootItem);
        return 1;
    }
    if(rootItem!=null&&!rootItem.getChildren().isEmpty()){
        for(TreeItem<String> treeItem: rootItem.getChildren()){
            count+=handleSearch(treeItem, text);
            if(this.count==count){
                break;
            }
        }
    }
    return count;
}
}