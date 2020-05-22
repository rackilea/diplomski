public void onCreate(SQLiteDatabase db1){
    String sql= "CREATE TABLE New_User("+Ename +" text not null," +
    ""+ Egender +" text not null," +
    ""+ Email +" text not null primary key," +
    "" +Epass+" text not null,"+
    ""+ Eabout +" text not null,"+
    ""+ Ehob1 +" text,"+ Ehob2 +" text,"+ Ehob3 +" text,"+ Ehob4 +" text);";
   db1.execSQL(sql);
}