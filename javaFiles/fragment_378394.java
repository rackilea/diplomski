int row=0;
while(rs.next()) {
    String name = rs.getString("name");
    String description = rs.getString("description");
    String location = rs.getString("location");
    jTable2.getModel().setValueAt(name, row, 0);//name at column 0 always
    jTable2.getModel().setValueAt(description, row, 1);//desc at column 1 always 
    jTable2.getModel().setValueAt(location, row, 2);//location at column 2 always
    row++;//increment row counter for each record
}