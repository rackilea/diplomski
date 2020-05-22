public static List <String> fromSDCard(Context context)
{
    List <String> listChurchWall = new ArrayList <String>();
    // listing Wallpaper using church names
    String string = "/mnt/sdcard/Church/Wallpaper/";
    f = new File (string+name+"/");
    if (f.exists()) 
     {
        files = f.listFiles ();
     }else{
         // 1. Instantiate an AlertDialog.Builder with its constructor
         AlertDialog.Builder builder = new AlertDialog.Builder(context);

         // 2. Chain together various setter methods to set the dialog characteristics
         builder.setMessage(R.string.dialog_message)
         .setTitle(R.string.dialog_title);

         // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        // 4. Show the dialog
        dialog.show()
     }                          
     return listChurchWall;  
}