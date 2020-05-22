String[] HerbalSuggesstionsArray =  searchText.getText().toString().trim().split("\\s*,\\s*");
String query = "SELECT _id, name, symptoms2 FROM hsdisease WHERE symptoms2 LIKE ?"

// Append as many WHERE clauses as necessary
for(int x= 0; x<HerbalSuggesstionsArray.length - 1; x++) {
    query += " OR symptoms2 LIKE ?";
}

cursor = db.rawQuery(query, HerbalSuggesstionsArray);

adapter = new SimpleCursorAdapter(
        this,
        R.layout.herbalsuggestion_list_item,
        cursor,
        new String[] {"name", "symptoms2"},
        new int[] {R.id.hsname, R.id.hssymptoms} );
setListAdapter(adapter);
searchText.getText().clear();