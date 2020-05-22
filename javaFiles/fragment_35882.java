template.execute("jvmInfo", new CollectionCallback<String>() {
  String doInCollection(DBCollection collection) {
    DBCursor cursor = collection.find(query)
    return cursor.next().toString()
  }
}