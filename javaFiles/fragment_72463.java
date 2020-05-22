public class MainController implements Initializable{

    @FXML
    private ListView<String> list;

    private AVLTree dictTree;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        dictTree = readData();
    }

    public void fillList()
    {

        List<String> aList = new ArrayList<>();
        String data = "Word: meaning1, meaning2, ... , meaningN / a synonym * an antonym";
        aList.add(data);
        dictTree.inOrder(aList);

        list.getItems.add(data);
    }

    public void openInsertWord() throws Exception
    {
        Stage primaryStage2 = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InsertUI.fxml"));
        Parent root = FXMLLoader.load();

        InsertWordController controller = loader.getController();
        // seems like these two things really contain the same information...
        // I don't think you need both of them?
        controller.setDictTree(dictTree);
        controller.setItemsList(list.getItems());

        primaryStage2.setTitle("Insert a word");
        primaryStage2.getIcons().add(new Image("file:icon.png"));
        primaryStage2.setScene(new Scene(root));
        primaryStage2.setResizable(false);
        primaryStage2.initStyle(StageStyle.UNDECORATED);
        primaryStage2.show();
    }
}