// Retrieve only the title of all the documents that can be found in the collection
DBCursor cursor = collection.find(
    new BasicDBObject(), new BasicDBObject("title", Boolean.TRUE)
);
while (cursor.hasNext()) {
    // Add the value of the title to the combo box
    comboBox.addItem((String) cursor.next().get("title"));
}