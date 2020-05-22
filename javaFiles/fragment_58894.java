myCollection.find().observe({
  added(document) {
    // Do something with new document
  },
  changed(document) {
    // Update analytics in response to change
  },
  removed(oldDocument) {
    // Update analytics in response to change
  }
});