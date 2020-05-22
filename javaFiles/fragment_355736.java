private void accessEachFileInZip (byte[] zipAsByteArray) throws IOException{
    ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(zipAsByteArray));

    while ((entry = zipStream.getNextEntry()) != null) {
        // The zipStream state refers now to the stream of the current entry
       ...
    }

    zipStream.close(); 
}