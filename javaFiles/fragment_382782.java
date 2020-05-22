public void addEdge(String start, String end) {
   this.vertices.forEach((e) -> {
       if(e.label.equalsIgnoreCase(start)) {
           e.adjNodeList.add(new Vertex(end));
       }
   });