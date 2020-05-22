int rowCount=jTable3.getRowCount();
String[] ItemList=new String[6];
String sqlItems="INSERT INTO IncomingTransactionItems(Incoming_Transaction_Number, Transaction_ID,Item_Number, Quantity, Unit_Price,Total_Price)values(?,?,?,?,?, ?)"
for(int rowctr=1;rowctr<rowCount;rowctr++){
     ItemList[0]= String.valueOf(rowctr);                 //    Incoming Transaction_Number
     ItemList[1]= this.jTextField1.getText();             //    Transaction ID
     ItemList[2]=this.jTable3.getModel().getValueAt(rowctr, 0).toString();              //    Item Number
     ItemList[3]=this.jTable3.getModel().getValueAt(rowctr, 2).toString();              //    Quantity
     ItemList[4]=this.jTable3.getModel().getValueAt(rowctr, 3).toString();              //    Unit Price
     ItemList[5]=this.jTable3.getModel().getValueAt(rowctr, 4).toString();              //    Total Price     

     try (PreparedStatement pst = conn.prepareStatement(sqlItems)){
        // You could do this with a for-loop, I've done it long
        // to demonstrate the use of PreparedStatement
        pst.setString(1, ItemList[0]);
        pst.setString(2, ItemList[1]);
        pst.setString(3, ItemList[2]);
        pst.setString(4, ItemList[3]);
        pst.setString(5, ItemList[4]);
        pst.setString(6, ItemList[5]);
        pst.executeUpdate();
    }
    catch(SQLException | HeadlessException e){
       Logger.getLogger(Encoding_Incoming_Batch.class.getName()).log(Level.SEVERE, null, e);
    }
}
this.UpdateJTable();