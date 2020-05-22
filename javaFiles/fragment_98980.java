db.beginTransaction(); 
try{
//Process inserts
//....
db.setTransactionSuccessful(); 
}catch(Exception e){

}finally{
db.endTransaction();
}