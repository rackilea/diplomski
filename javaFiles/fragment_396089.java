private DBHelper mydb ;
  mydb = new DBHelper(this);

   //insert
   if(mydb.insertBarcode(EditText1.getText().toString(), 
                       EditText2.getText().toString())){
              Toast.makeText(getApplicationContext(), "done",
                       Toast.LENGTH_SHORT).show();  
    } else{
           Toast.makeText(getApplicationContext(), "not done", 
                   Toast.LENGTH_SHORT).show();  
    }

   //Read
   Cursor getBarcode= mydb.getData(id_to_search);