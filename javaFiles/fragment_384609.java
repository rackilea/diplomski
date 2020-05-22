public void okayBtnPressed() throws SQLException, IOException{
    con = handler.getConnection();

    String query1 = "SELECT COUNT(*) FROM assigned WHERE Date BETWEEN ? AND ?";
    pst = con.prepareStatement(query1);
    pst.setString(1, datePickerFrom.getValue().toString());
    pst.setString(2, datePickerTo.getValue().toString());
    ResultSet rs = pst.executeQuery();

    int count = rs.next().getInt(1);

    rs.close();
    pst.close();

    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/bownhrmain1/reports/assignedReport.fxml"));
    Parent root = myLoader.load();
    AssignedReportController assignedController = myLoader.getController();

    if(count == 0){
      // no results  
    } else {        
        System.out.println(""+count);
        System.out.println(datePickerFrom.getValue().toString());
        System.out.println(datePickerTo.getValue().toString());

        date1 = datePickerFrom.getEditor().getText();
        date2 = datePickerTo.getEditor().getText();

        assignedController.setDates(date1, date2, count);

        Stage window = (Stage)(okayBtn.getScene()).getWindow();
        Scene scene = new Scene(root);
        window.setScene(scene);           
    }     
}