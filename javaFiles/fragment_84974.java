public void addCustomerToTable(int accountNum, String fname, String mname, String lname, double deposit){
    String account = Integer.toString(accountNum);
    String fnames = fname;
    String mnames = mname;
    String lnames = lname;
    String deposits = Double.toString(deposit);

    DefaultTableModel table = (DefaultTableModel) jTable2.getModel();
    Object row[] = {account, fnames, mnames, lnames, deposits};
    table.addRow(row);  
}