String currentTitle="";
  String currentAuthor="";

      int rows = Cursor.getCount();
      Cursor.moveToFirst();
      for(int i=0;i<rows;i++){

         int bookId = c.getInt(0);

          if(bookId==id){
             //now You got the entry and can get all informations You want
             currentTitle = cursor.getString(1);
             currentAuthor = cursor.getString(2);
             c.moveToNext();
          }
       }