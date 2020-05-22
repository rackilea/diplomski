public Boolean setNotes(String book,String chapter,String verse,String note){

        SQLiteDatabase mDb = this.getWritableDatabase();
        Boolean flag = false;
        try{
            Cursor c = mDb.rawQuery("UPDATE "+book+" SET footnotes='" + note + "' WHERE chapter="+chapter+" and verse="+verse+"", null);
            c.moveToFirst();
            c.close();
            flag = true;
        } catch (Exception e) {
            Log.e("getCrossReferences", e.getMessage());
        }
        mDb.close();
        return flag;
    }