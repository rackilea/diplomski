HashMap<Flows, FlowStatics> myHashMap = new HashMap<Flows, FlowStatics>();
for (int i = 0; i < 10; i++) {
  // OP commented that the map is populated in a loop
  myHashMap.put(createNewFlow(), createNewFlowStatistics());  // populate map
}
System.out.printf("Number of items in Map: %s%n", myHashMap.keyset().size());