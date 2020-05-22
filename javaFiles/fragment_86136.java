// Use generic types
public ObservableList<XYChart.Data<String, Number>> getItemGraphStatistics(){
    ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();

    String sql = "SELECT itemID, COUNT(*) FROM (SELECT itemID FROM SALES UNION ALL SELECT itemID FROM STOCK) t GROUP BY itemID";
    System.out.println(sql );
    ResultSet rs = handler.execQuery(sql);
    try{

        while(rs.next()){
            String item= rs.getString("itemID");
            int count = rs.getInt(2);

            // add diamond operator "<>"
            data.add(new XYChart.Data<>(item+ "(" + count + ")", count));

        }
    } catch (SQLException ex) {
        Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    return data;

}