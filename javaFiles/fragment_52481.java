Scanner in = new Scanner(new File("names.txt")).useDelimiter("[\",]+");
  ArrayList<String> text = new ArrayList<String>();
  while (in.hasNext()) {
    text.add(in.next());
  }
  Collections.sort(text);