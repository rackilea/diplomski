List<String> linesInFile1 = new ArrayList<>();
List<String> linesInFile2 = new ArrayList<>();
while (w.hasNextLine()) {
    String lineW = w.nextLine();
    linesInFile1.add(lineW);
}
while(s.hasNextLine()) {
    String lineS = s.nextLine();
    linesInFile2.add(lineS);
}

linesInFile1.retainAll(linesInFile2);
j = linesInFile1.size();