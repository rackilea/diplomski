//here idColumnName is the colum you want to select
//comparatorColumn is the column you want to check with the WHERE clause
//valueToBeChecked is the string you use to check for availablility
//Use db.query() rather than db.rawQuery() as your valueToBeChecked might contain special characters which can produce an SQL exception
Cursor res = db.query(tableName,new String[]{idColumnName},"comparatorColumn =?",new String[]{valueToBeChecked},null,null,null);
//check the cursor like this
if(res!=null && res.moveToFirst(){
    //cursor contains data
}else{
    //no valid entry in the table
}