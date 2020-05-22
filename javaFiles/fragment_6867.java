String fileContent = "line1\nline2\nline3\nline4\n";
  // -1 limit tells split to keep empty fields
  String[] fileLines = fileContent.split("\n", -1);
  String lastLine = fileLines[fileLines.length - 1];
  boolean lastLineIsEmpty = false;
  if(lastLine.trim().isEmpty())
  {
     lastLineIsEmpty = true;
  }

  //prints true, line4 followed by carriage return but 
  //no line 5
  System.out.println("lastLineEmpty: " + lastLineIsEmpty);