@Test public void contextMenuShouldWork() {
  ContextMenuInfo info =
      new AdapterView.AdapterContextMenuInfo(view, position, id);
  systemUnderTest.onCreateContextMenu(menu, view, info);

  /* assert success here */
}