//Step1 : Checked accessiblity on sd card
public boolean doesSDCardAccessible(){
    try {
        return(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED));        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();        
    }   
    return false;
    }

//Step2 : create directory on SD Card
//APP_DIR : your PackageName 
public void createAndInitAppDir(){
    try {
    if(doesSDCardAccessible()){
    AppDir = new File(Environment.getExternalStorageDirectory(),APP_DIR+"/");
    if(!AppDir.exists()){
        AppDir.mkdirs();    
    }
    }
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    }

//Step 3 : Create Database on sdcard
//APP_DIR : your PackageName 
//DATABASE_VERSION : give Database Vesrion
//DATABASE_NAME : your Databsename Name
public void initDB()
{
    try {

    //Using SQLiteHelper Class Created Database
    sqliteHelper = new SQLiteHelper(Application.this,AppDir.getAbsolutePath()+"/"+DATABASE_NAME, 
                                    null, DATABASE_VERSION);    

    //OR use following
    //Creating db here. or db will be created at runtime whenever writable db is opened.

    db = SQLiteDatabase.openOrCreateDatabase(AppDir.getAbsolutePath()+"/"+DATABASE_NAME,                                                     null);*/
    db= sqliteHelper.getWritableDatabase();
    db.close();
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
}