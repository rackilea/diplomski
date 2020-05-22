public static void main(String[] args) {
  try {
    // body of main method goes here, including any other error handling
  } catch (Throwable t) {
    JOptionPane.showMessageDialog(
        null, t.getClass().getSimpleName() + ": " + t.getMessage());
    throw t; // don't suppress Throwable
  }
}