SQLiteDatabase db = LlistaRevisionsClientsActivity.getDB(context);
Cursor cursorp = db.rawQuery("select * from table", null);
try
{
    if (cursorp.moveToFirst())
    {  
        if (productesRevisionsClientsCursor.moveToFirst())
        {
           do{
               lst.add(cursorp.getString(cursorp
                  .getColumnIndex("nom")));
           } while (cursorp.moveToNext());
        }  
   } 
 }finally
 {
   cursorp.close();
 }
spinner = (Spinner) findViewById(R.id.productes_spinner);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, lst);
// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(R.layout.spinner_productes);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);