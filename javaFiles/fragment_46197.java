public class QuickSearchProvider extends SearchRecentSuggestionsProvider {

  public final static String AUTHORITY = "com.example.testapp.providers.QuickSearchProvider";
  public final static int MODE = DATABASE_MODE_QUERIES | DATABASE_MODE_2LINES;

  public QuickSearchProvider() {
    setupSuggestions(AUTHORITY, MODE);
  }

  public Cursor query(Uri uri, String[] projection, String sel,
      String[] selArgs, String sortOrder) {

      MatrixCursor cursor = new MatrixCursor(new String[] { 
          BaseColumns._ID,
          SearchManager.SUGGEST_COLUMN_TEXT_1,
          SearchManager.SUGGEST_COLUMN_TEXT_2,
          SearchManager.SUGGEST_COLUMN_ICON_1,
          SearchManager.SUGGEST_COLUMN_QUERY,
          SearchManager.SUGGEST_COLUMN_INTENT_ACTION});

      cursor.addRow(new Object[] { 0, "Plants", "Search Plants", android.R.drawable.ic_menu_search, selArgs[0], Search.SEARCH_PLANTS_ACTION});
      cursor.addRow(new Object[] { 1, "Birds", "Search Birds", android.R.drawable.ic_menu_search, selArgs[0], Search.SEARCH_BIRDS_ACTION });

      return new MergeCursor(new Cursor[] { cursor });
  }

}