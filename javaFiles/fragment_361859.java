int lineNo = 0;
List<String> theOnesICareAbout = new LinkedList<String>();
while (partscan.hasNextLine()){
  String line=partscan.nextLine();
  if (isOneOfTheImportantLines(lineNo)) {
    theOnesICareAbout.add(line);
  }
}
partscan.close();