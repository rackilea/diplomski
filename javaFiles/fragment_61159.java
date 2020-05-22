while (fileDoc.hasNext()) {
  if (fileDoc.hasNextInt()) {
    int number = fileDoc.nextInt();
    /* Do whatever... */
  } else {
    fileDoc.next();
  }
}