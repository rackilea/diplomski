public void close(AutoCloseable closeable) {
  try {
    closeable.close();
  } catch (Exception e) {
    //Just log the exception. there's not much else you can do, and it probably doesn't
    //matter. Don't re-throw! 
  }
}