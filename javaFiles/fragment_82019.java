public class MyActivity extends Activity {
  /** visible for testing */
  MyHelper helper = new MyHelper();

  public void onCreateContextMenu(
      ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    int position = helper.getPositionFromContextMenuInfo(menuInfo);
    // ...
  }
}