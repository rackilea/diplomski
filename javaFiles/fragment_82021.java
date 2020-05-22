public class MyActivity extends Activity {
  public void onCreateContextMenu(
      ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    AdapterView.AdapterContextMenuInfo info =
        (AdapterView.AdapterContextMenuInfo) menuInfo;
    onCreateContextMenuImpl(info.position);
  }

  /** visible for testing */
  void onCreateContextMenuImpl(int position) {
    // the bulk of the code goes here
  }
}

@Test public void contextMenuShouldWork() {
  systemUnderTest.onCreateContextMenuImpl(position);

  /* assert success here */
}