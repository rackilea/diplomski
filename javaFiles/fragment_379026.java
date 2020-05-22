Cursor cursor = null;
 String sql ="SELECT PID FROM "+TableName+" WHERE PID="+pidValue; 
 cursor= db.rawQuery(sql,null);
 Log("Cursor Count : " + cursor.getCount());

 if(cursor.getCount()>0){
  //PID Found
 }else{
 //PID Not Found 
 }
 cursor.close();