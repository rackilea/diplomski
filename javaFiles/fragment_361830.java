if(cursor.moveToFirst()) //this will move cursor to first position
{
   do{
//your code to fetch data from cursor
  ListArray.add(cursor.getInt(cursor.getColumnIndex("COL_2")));
    }while(cursor.moveToNext());
}