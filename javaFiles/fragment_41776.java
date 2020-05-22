public void executeEventInsert(String name, String score){
     //For write data to your database
     SQLiteDatabase db = this.getWritableDatabase();
    String query="INSERT INTO universityFinder(univName, score) VALUES('"+name+"','"+score+"');";
    db.execSQL(query);
}