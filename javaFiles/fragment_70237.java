public static ArrayList<String> getAlreadyProcessedPhotos(Context context, ArrayList<String> photos, SQLiteDatabase db)
{
   ArrayList<String> notAlreadyProcessedPhotos = new ArrayList<>();
   ArrayList<String> preProc = new ArrayList()

   for (String item: photos) {
       preProc.add("'" + item + "'");
   } 
   String inClause = TextUtils.join(",", preProc);

   String searchQuery = "SELECT " + DatabaseHelper.PATH_COLUMN + "FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.PATH_COLUMN + "NOT IN (" +inClause + ")";
   Cursor cursor = photosDb.rawQuery(searchQuery);

   while(cursor.moveToNext()) 
   {
        notAlreadyProcessedPhotos.add(cursor.getString(0);
   }

   return notAlreadyProcessedPhotos;
}