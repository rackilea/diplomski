public int checkLogin(String incomingUsername, String incomingPassword){

String[] selectionArgs = new String[]{incomingUsername, incomingPassword};
try
{
    int i = 0;
    Cursor c = null;
    c = db.rawQuery("select * from Registration where username=? and password=?", selectionArgs);
    c.moveToFirst();
    i = c.getCount(); 
    c.close(); 
    return i;
}
catch(Exception e)
{
    e.printStackTrace();
}
return 0;