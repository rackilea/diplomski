final Node dataNode1 = GRAPH.addNode("One");
((DataNode)dataNode1).setStringData("StringData_1");
((DataNode)dataNode1).setIntegerData(1);

final Node dataNode2 = GRAPH.addNode("Twi");
((DataNode)dataNode1).setStringData("StringData_2");
((DataNode)dataNode1).setIntegerData(2);

GRAPH.addEdge("Some", dataNode1, dataNode2);