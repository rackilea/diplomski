File f = new File(filename);
  Scanner input = new Scanner(f);
  List<List<String>> nestedLists = new ArrayList<>();
  while (input.hasNextLine()) {
     String line = input.nextLine();
     List<String> innerList = new ArrayList<>();
     Scanner innerScanner = new Scanner(line);
     while (innerScanner.hasNext()) {
        innerList.add(innerScanner.next());
     }
     nestedLists.add(innerList);
     innerScanner.close();
  }
  input.close();