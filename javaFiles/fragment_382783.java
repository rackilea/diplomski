public Vertex fetchNode(String label) {
   return this.vertices.stream()
              .filter(v -> v.getLabel().equals(label))
              .findAny()
              .orElseGet( () -> {
                  Vertex newVertex = new Vertex(label));
                  this.vertices.add(newVertex);
                  return newVertex;
               });
  }

  public void addEdge(String start, String end) {
     this.vertices.forEach((e) -> {
         if(e.label.equalsIgnoreCase(start)) {
             e.adjNodeList.add(fetchNode(end));
         }
     });
  }