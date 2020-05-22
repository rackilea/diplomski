public String reportGenerateNew() {
  try {
    // Trap and print any errors or exceptions from the existing code.
    reportGenerate();
  }
  catch( Exception e ) {
    e.printStackTrace();
  }
}