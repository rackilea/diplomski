public static final int MYSQL_DUPLICATE_PK = 1062; // Replace 1062 with exception no. you are getting in case it is different for different    database

try{
    String query="INSERT INTO Products(Pro_Id  ,Pro_Name,Pro_Price,Pro_Quantity,Pro_Supplier_id)VALUES ('"+Pro_Id.getText()+" ','"+Pro_Name.getText()+" ','"+Pro_Price.getText()+" ','"+Pro_Quantity.getText()+" ','"+Pro_Supplier_id.getText()+" ') ";
    executeSQLQuery(query,"Inserted");
} catch(SQLException e){
if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
   System.out.println("Primary key already used");
}
}