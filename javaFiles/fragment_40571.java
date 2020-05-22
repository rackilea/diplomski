public void goLogin(String id, String pass){

// Since i changed the Query, you need to pass in the ID and Password to let the Query to filtering

String DatabaseID = getIDFromDB(id, pass);    

   // Simple Logic, If DatabaseID have value which mean the ID and Password is correct
   // Because the Database Query will return null if the ID and Password is Wrong

   if(DatabaseID!=null){
     System.out.println("ID and Password is Correct.");   
   }else{
     System.out.println("ID or Password is Incorrect.");
   }

}