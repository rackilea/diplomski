FileReader reader;

try {
  reader = new FileReader("someNonExistingFile");
} catch (FileNotFoundException e) {
   // handle FileNotFoundException
   e.printMessage();
} finally {
   // reader MUST BE CLOSED ALWAYS, so FINALLY, CLOSE IT
   reader.close();
}