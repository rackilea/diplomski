public boolean chkpPw (String pPw, String pId){
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.rawQuery("Select * from person where pPw=? and pId=?", new String[]{pPw, pId});
    if (cursor.getCount()>0) {
        return true;
    }
    else {
        return false;
    }
}