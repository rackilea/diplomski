Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","password");
System.out.println("Connected database successfully...");
PreparedStatement ps = con.prepareStatement( "select * from web");          

ResultSet rs = ps.executeQuery();                   
bx = new JComboBox();
while ( rs.next()) 
{
    String s = rs.getString(1);                               
    bx.addItem(s);    
} 


bx.setBounds(150, 20, 200, 20);
f.add(bx);