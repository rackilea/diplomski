List<List<Integer>> adjList = new ArrayList<List<Integer>>();

adjList.add(new ArrayList<Integer>()); // initialise new ArrayList<Integer>
adjList.get(0).add(1); // add value one by one
adjList.get(0).add(2);

adjList.add(new ArrayList<Integer>());
adjList.get(1).add(10);
adjList.get(1).add(20);