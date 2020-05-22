try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sonoo","root","root");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("SELECT first_name FROM table WHERE username = '"+ userName+"';");
String fname;  
while(rs.next())  
fname=new String(rs.getString(1));
System.out.println("First Name:"+fname);  
con.close();  
}
catch(Exception e){ 
  System.out.println(e);
 }