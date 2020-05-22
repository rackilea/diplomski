for(int i=0; i<table1.getRowCount();i++){
    ps.setString(1, customer_name);
    ps.setString(2, phone); 
    ps.setString(3, table1.getValueAt(i, 0).toString());
    ps.executeUpdate();
}