int confirm = Home.getStatement().executeUpdate(Query);
if(confirm == 1)
{
    JOptionPane.showMessageDialog(null,"Record Added","Saved",1);
    new Main().updateTable();  // ****** HERE ******
}