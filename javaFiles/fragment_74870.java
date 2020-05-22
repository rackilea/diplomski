public void addEdge(char a, char b, double weight) {
    Edge e = new Edge(a, b, weight); // 1. creating the Edge
    a = e.vA;            // 2. assigning the 'edge.vA'-value to 'a' ... why?
    b = e.vB;            // 3. same here with 'b'
    e.setWeight(weight); // 4. weight was already set when creating object on line 1
    edges.get(a).add(b); // 5. here you add the node 'b' to the list... what about the weight?
    // 6. now you exit the method without storing the created edge 'e'
}