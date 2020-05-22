List<Graph.Edge> list = new ArrayList<Graph.Edge>();

try {
    Scanner scanner = new Scanner(new File(filepath));
    while(scanner.hasNextLine()){
        String source = scanner.findInLine(NAME);
        if (source != null) {
            while(true) {
              String to = scanner.findInLine(NAME);
              if (to == null) {
                  break;
              }
              int weight = Integer.valueOf(scanner.findInLine(WEIGHT));
              list.add(new Graph.Edge(source, to, weight));
            }
        }
        scanner.nextLine();
    }
} catch (Exception e) {
    e.printStackTrace();
}