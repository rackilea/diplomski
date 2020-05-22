private static void setDragAndDrop(JList<String> jlist) {
    jlist.setDragEnabled(true);
    jlist.setDropMode(DropMode.INSERT);
    jlist.setTransferHandler(new ListTransferHandler());
    AutoscrollWorkaround.applyTo(jlist); // <--- just this line added
}