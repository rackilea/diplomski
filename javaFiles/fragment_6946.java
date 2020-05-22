SQLiteDatabase.update() returns number of rows affected. So,
 in your case, no rows were affected (most probably because of your WHERE clause)

    ----------
       int result = 0;
        try{
         result = db.update("alarms", values,  keyId+" = ? " ,new String[]{row});
        Log.d("result", ""+result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        SYstem.out.println("number of row affected :" + result );