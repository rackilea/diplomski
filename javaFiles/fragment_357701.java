try {
  mediaPlayer.setDataSource(audioFile);
  mediaPlayer.prepare();
  mediaPlayer.start();
} catch (IOException e) {
  Log.e(TAG, "Could not open file " + audioFile + " for playback.", e);
}