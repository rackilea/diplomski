@FXML
TableView <Customer> customerView;

@FXML
TableColumn<Customer, String> idColumn;
@FXML
TableColumn<Customer, String> nameColumn;
@FXML
TableColumn<Customer, String> addressColumn;
@FXML
TableColumn<Customer, String> phoneColumn;

ObservableList<Customer> observableCustomers;

// init method or constructor, whatever suits your needs
private void initTable() {

    observableCustomers = FXCollections.observableArrayList();
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
}

public void table_load()
{

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root","");
        pst = con.prepareStatement("select * from records");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rd = rs.getMetaData();

        // CAST/TRANSFORMATION TO BE DONE BY YOU
        List<Customer> customerList = ((List<Customer>) rs.toList());

        // only if necessary
        observableCustomers.clear();
        // add customers
        observableCustomers.addAll(customerList);

    } catch (SQLException ex) {

    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }

}