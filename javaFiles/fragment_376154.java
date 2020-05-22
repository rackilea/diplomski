String table = TABLE_FLAVOURS;
StringBuilder where = new StringBuilder() ;
String[] args = text.split(",");

//construct args with proper formatting
String[] likeArgs = new String[args.length];

for (int i = 0; i < args.length; i++){
    //construct LIKE args
    likeArgs[i] = "%" + args[i] + "%";

    //construct where clause
    if (i == 0){
       where.append(KEY_DESCRIPTION + " LIKE ?");
    }
    else{
        where.append(" OR " + KEY_DESCRIPTION + " LIKE ?");
    }
}

SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.query(table, null, where.toString(), likeArgs, null, null, null);