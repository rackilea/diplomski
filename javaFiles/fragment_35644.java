@SuppressWarnings("deprecation")
SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, 
        android.R.layout.simple_list_item_1, 
        cursor, 
        new String[] {DBsearchRef.KEY_NAME}, 
        new int[] {android.R.id.text1});
searchedListResults.setAdapter(cursorAdapter);