checkDB()
{
try{
      SQLiteDatabase   dbe = SQLiteDatabase.openDatabase("selectedFilePath", null,0);
        Log.d("opendb","EXIST");
        dbe.close();
         // DB exits then delete
        File file = new File(selectedFilePath);
        boolean deleted = file.delete(); <--- this will help you to delete DB

    }
    catch(Exception e)
    {
         // DB not exits code to copy database
    }
 }