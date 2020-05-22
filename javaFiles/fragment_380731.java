File fia = new File(Environment.getExternalStorageDirectory()+"/my_folder/db/my_file_1");
File fia2 = new File(Environment.getExternalStorageDirectory()+"/my_folder/db/my_file_2");
File fia3 = new File(Environment.getExternalStorageDirectory()+"/my_folder/abc/my_file_3");
File fia4 = new File(Environment.getExternalStorageDirectory()+"/my_folder/abc/my_file_3");
File fia5 = new File(Environment.getExternalStorageDirectory()+"/my_folder/xyz/my_file_5");
if(fia.exists() && fia2.exists() && fia3.exists() && fia4.exists() && fia5.exists())
   {                        
     //do something 
   } else {                       
   Toast.makeText(getApplicationContext(), "Database is not available. Please install it.", Toast.LENGTH_LONG).show();                      
}