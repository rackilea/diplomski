public ArrayList<HashMap<String,String>> executeSelectEvents(int input){
    String query="select * from "+TABLE_NAME+ " where " +COLUMN_SCORE+" >="+input;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor= db.rawQuery(query,null);
    ArrayList<HashMap<String,String>> events=new ArrayList<>();
    while (cursor.moveToNext()){
        HashMap<String,String> event=new HashMap<>();

        String colUniversityId=cursor.getColumnName(0);
        String colUniversityIdValue=cursor.getString(0);
        String colUniversityName=cursor.getColumnName(1);
        String colUniversityValue=cursor.getString(1);


        event.put(colUniversityId,colUniversityIdValue);
        event.put(colUniversityName,colUniversityValue);
        events.add(event);
    }
    return events;
}