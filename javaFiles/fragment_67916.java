// Java 8
Node n;
Edge e;
String[] splittedLine;
String[] splittedEdge;
HashMap<String, Node> stationNumberToNode = new HashMap<>();
// if the file is not too large, you can read the file at once
List<String> lines = Files.readAllLines(new File("path/to/file.txt").getPath());
for(String line : lines){
  splittedLine = line.split(" ");
  if((n = stationNumberToNode.get(splittedLine[0]) == null){
    n = new Node(splittedLine[0]); // assuming your Node has a constructor that takes the station id
    stationNumberToNode.put(stationNumberToNode[0], n);
  }
  for(int i = 1; i < splittedLine.lenght; ++i){
    splittedEdge = splittedLine[i].split(",");
    e = new Edge(splittedEdge[0], splittedEdge[1]); // assuming your Edgehas a constructor that takes the destination station and the cost
    n.addEdge(e);
  }
}