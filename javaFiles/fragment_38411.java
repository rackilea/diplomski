//Creating and Executing RowSet  
JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
rowSet.setUrl("jdbc:mysql://localhost:3306/litrealty");  
rowSet.setUsername("root");  
rowSet.setPassword("password");  

rowSet.setCommand("select Id, Name, Salary from employee");  
rowSet.execute();

while (rowSet.next()) {
    System.out.println("Id: " + rowSet.getString(1));  
    System.out.println("Name: " + rowSet.getString(2));  
    System.out.println("Salary: " + rowSet.getString(3));  
}