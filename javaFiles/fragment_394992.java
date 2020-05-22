public int findID (String lemail){
    SQLiteDatabase db = this.getReadableDatabase();
    int k ;

    // Try changing here TABLE_IDENTIFICATION or TABLE_Temp..!!

    Cursor res = db.rawQuery("select * from " + TABLE_PERSONNE + " WHERE profile='"+lemail+"'", null);
    if (res.getCount()>0){
        res.moveToFirst();
        k=res.getInt(res.getColumnIndexOrThrow("ID"));
    }else k =-1;
    return  k;
}