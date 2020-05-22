try {
  deserializeOpen();
  setVisible(true);
} catch(Exception e) {
  e.printStacktrace(); // or any other error handling
}