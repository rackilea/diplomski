while(cursor.moveNext()){
  try {
    MediaMetadataRetriever mmr = new MediaMetadataRetriever();
    mmr.setDataSource("Path to the file"); // /storage/337C 1C15/Music/Edguy/Speedhoven.mp3
  } catch (RuntimeException ex) {
    // something went wrong with the file, ignore it and continue
  }
}