Connection connection = getDBConnection(); //Depends on how you get your connection
boolean autoCommit = connection.getAutoCommit();
try{
    //Set autoCommit to false. You will manage commiting your transaction
    connection.setAutoCommit(false); 
    //Perform your sql operation

    if(doCommit){ //all your ops have successfully executed, you can use a flag for this
        connection.commit();
    }
}catch(Exception exe){
    //Rollback
}finally{
    connection.setAutoCommit(autoCommit); //Set autoCommit to its initial value
}