Element[][] grid = readFile();
for (Element[] ea : grid) {
    for (Element e : ea)
         System.out.print(e.getChar());
     System.out.println();
}