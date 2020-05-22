for (int i=0; i<readFile.size();i++)
  {
    String n = readFile.get(i);
    n = n.replaceAll(findWord,replaceWord);
    readFile.add(i,n);
  }