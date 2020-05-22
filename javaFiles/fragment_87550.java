//----- SOLUTION method to add data into database
    public void AddExerData(String newEntry){
//      if you have a field (class level variable)  SqliteDatabase db;
        db = new YourDBHelperClass().getWriteabledatabase();
        boolean insertData = db.addexerData(newEntry);
        if(insertData){
            toastMessage("Data Successfully Inserted");
        }else{
            toastMessage("Something went wrong");
        }

    }