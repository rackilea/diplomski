String allitem="";
    for(int i = 0;i<jList1.getModel().getSize();i++)
    {
        allitem = (String)jList1.getModel().getElementAt(i)+"::"+allitem;
    }

try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "");
    PreparedStatement stmt = conn.prepareStatement("insert into listt (listitem) values (?)");
    stmt.setString(1, allitem);
    stmt.execute();
    conn.close();
}catch(
Exception e)
{
    JOptionPane.showMessageDialog(null, e);
    e.printStackTrace();
}