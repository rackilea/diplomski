@FXML
 private TableView<PoJoName> table;

 @FXML
 private TableColumn<PoJoName, Integer> col1;

 @FXML
 private TableColumn<PoJoName, String> col2;

 public ObservableList<PoJoName> data; 

@FXML
void initialize() 
{

  col1.setCellValueFactory(new PropertyValueFactory<PoJoName,Integer>("id")); // here id is a variable name which is define in pojo.
  col2.setCellValueFactory(new PropertyValueFactory<PoJoName,String>("name"));

    data  =  FXCollections.observableArrayList();        
    SessionFactory sf = new Configuration().configure().buildSessionFactory();
    Session sess  =sf.openSession();        
    Query qee = sess.createQuery("from PoJoName");
    Iterator ite  =qee.iterate();
    while(ite.hasNext())
    {
        PoJoName obj = (PoJoName)ite.next();    

        data.add(obj);           
    }        
    table.setItems(data);

}