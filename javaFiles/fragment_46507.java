try {
  BufferedReader reader = new BufferedReader(new FileReader(new File("/path/to/File")));
  String currLine;
  while ((currLine = reader.readLine()) != null) { // returns null at EOF
      if (!isValid(currLine)) throw new BankAccountException();
  }
} catch (BankAccountException e) {
  // same
} finally {
    reader.close();
}