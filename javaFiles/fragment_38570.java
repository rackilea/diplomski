try (FileReader fr = new FileReader(fil);
     BufferedReader inFil = new BufferedReader(fr)) {
  // ...

  // No need to close `fr` or `inFil` explicitly.
}