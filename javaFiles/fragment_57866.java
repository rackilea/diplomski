List<MyEdgeModified> modifiedList = new List<MyEdgeModified>();

// This is what you want to do, but which doesn't work
List<MyEdge> edgeList = modifiedList;

// Now this would have to be valid...
edgeList.add(new MyEdge());

// And this should be valid too...
MyEdgeModified modified = modifiedList.get(0);