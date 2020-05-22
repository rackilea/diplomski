/** This is only a good idea in a world where you can't instantiate the type. */
@Test public void contextMenuShouldWork() {
  ContextMenuInfo info = getSomeInfoObjectYouCantChange();

  MyHelper mockHelper = Mockito.mock(MyHelper.class);
  when(mockHelper.getPositionFromContextMenu(info)).thenReturn(42);
  systemUnderTest.helper = mockHelper;
  systemUnderTest.onCreateContextMenu(menu, view, info);

  /* assert success here */
}