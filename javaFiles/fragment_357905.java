@FXML
    private void goSearch(ActionEvent event) throws IOException, SQLException{


          try{

        conn = SqlConnection.ConnectDB();
        String criteria = txt_search.getText();
        if (criteria.trim().length() == 0) { return; }
        String[] arryCriterion = criteria.split(" ");
        List<String> results = new ArrayList<>();

        for (int i = 0; i < arryCriterion.length; i++) {

            List<String> text = populateField(arryCriterion[i], conn);

            results.addAll(text);

        }

        You need to convert it to an ObservableList.

 ObservableList<String> observableList = FXCollections.observableList(results);

        table_title.setItems(observableList );

    }finally{
        conn.close();
    }
}   
    @FXML
    private List<String> populateField(String s, Connection conn) throws SQLException{

    List<String> myList = new ArrayList<>();

    String sql = "SELECT * FROM table_entry WHERE colTitle LIKE ? ";


    pst=conn.prepareStatement(sql);

    pst.setString(1, "%" + s + "%");
    rs = pst.executeQuery();
    while (rs.next()) {
        myList.add(rs.getString("colTitle"));
    }
    return myList;

    }