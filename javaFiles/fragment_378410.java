public static void generateAvgLengthPathFile(String luceneIndexPath, String outputFilePath) {
    try {
        Directory dir = FSDirectory.open(new File(luceneIndexPath));
        IndexReader reader = IndexReader.open(dir);
        int totalLength = 0;
        //here we loop through all the docs in the index 
        for (int i = 0; i < reader.maxDoc(); i++) {
            if (reader.isDeleted(i)) {
                continue;
            }
            Document doc = reader.document(i);
            totalLength += Integer.parseInt(doc.get("docLength"));
        }
        //calculate the avarage length
        float avarageLength = totalLength * 1.0f / reader.maxDoc() * 1.0f;
        //create the a String varibale with the correct formate
        String avgLengthPathFile = "contents" + "\n" + avarageLength;

        //finally, save the file 
        Writer output = null;
        String text = "contents" + "\n" + avarageLength;
        File file = new File(outputFilePath);
        output = new BufferedWriter(new FileWriter(file));
        output.write(text);
        output.close();

    } catch (Exception e) {
System.err.println(e);
    }
}