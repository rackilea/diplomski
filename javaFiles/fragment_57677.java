row.setOnDragDetected(event -> {
   if (!row.isEmpty()) {
      Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
      db.setDragView(row.snapshot(null, null));
      ClipboardContent cc = new ClipboardContent();

      // Here you provide the ClipboardContent instance with the selected indexes instead of just one index.
      cc.put(SERIALIZED_MIME_TYPE, new ArrayList<Integer>(getSelectionModel().getSelectedIndices()));
      db.setContent(cc);
      event.consume();
   }
});