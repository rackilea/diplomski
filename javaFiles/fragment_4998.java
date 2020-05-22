if ((nextLine.startsWith("/*") && nextLine.endsWith("*/"))
    || (nextLine.trim().matches("[};]+"))) {
  //This line needs to be ignored
  ignoredLines++';
  continue;
}