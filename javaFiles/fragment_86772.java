public static final int MYSQL_DUPLICATE_PK = 1062;

try{
    //code that throws sql exception
} catch(SQLException e){
    if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
        //duplicate primary key 
    }
}