StringBuilder concat = new StringBuilder();

IndexReader reader = DirectoryReader.open(directory);

concat.append("Path , Parent \n" );
for( int i = 0; i <reader.maxDoc(); i++)  {
    Document doc = reader.document(i);

    String docPath = doc.get("path");
    String docParent = doc.get("Parent");

    concat.append(docPath + "," + docParent + "\n");

}