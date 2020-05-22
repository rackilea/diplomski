@Override
protected void cancelled() {
  try {
    socket.close();
  } catch( IOException e ) {
    // Never mind.
  }
}