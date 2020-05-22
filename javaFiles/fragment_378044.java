MediaMetadataRetriever retriever = new MediaMetadataRetriever();
try {
   retriever.setDataSource(filePath);
   //here 5 means frame at the 5th sec.
    bitmap = retriever.getFrameAtTime(5);
    } catch (Exception ex) {
   // Assume this is a corrupt video file
}