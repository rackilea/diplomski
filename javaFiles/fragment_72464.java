public class InsertWordController {

    @FXML
    private TextField iWord;
    @FXML
    private TextField iMeanings ;
    @FXML
    private TextField iSyn ;
    @FXML
    private TextField iAnt ;

    private AVLTree dictTree ;
    private List<String> itemsList ;

    public void setDictTree(AVLTree dictTree) {
        this.dictTree = dictTree ;
    }

    public void setItemsList(List<String> itemsList) {
        this.itemsList = itemsList ;
    }

    public void closeInsertWord()
    {
        iWord.getScene().getWindow().hide();
        String data = "Word: meaning1, meaning2, ... , meaningN / a synonym * an antonym" ;
        List<String> aList = new ArrayList<>();
        aList.add(data);
        dictTree.inOrder(aList);
        itemsList.add(data);
    }
}