Document doc = new Document();
String title = nameOfYourFile;
doc.add(new Field("title", title, Field.Store.YES, Field.Index.ANALYZED));  // adding title field
String content = contentsOfYourFile;
doc.add(new Field("content", content, Field.Store.YES, Field.Index.ANALYZED)); // adding content field
writer.addDocument(doc);  // writing new document to the index