@Test
  public void testGetRightListSelectionListner()
  {
    MultipleSelectionEditor multipleSelectionEditor = new MultipleSelectionEditor();
    ListSelectionEvent listSelectionEvent = mock(ListSelectionEvent.class);

    multipleSelectionEditor.getLeftListSelectionListner().valueChanged(listSelectionEvent);

  }