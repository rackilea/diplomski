public static void main(String[] args) {
    try {
        BufferedReader br = new BufferedReader(new StreamReader(System.in));
        String line = br.readLine();


        if (line != null) {
            //read nodes
            String[] nodeNames = line.split(" ");
            int[] nodes = new int[nodeNames.length]
            for (int i = 0; i < nodes.length; ++i) {
               nodes[i] = Integer.parseInt(nodeNames[i]);
            }

            //create graph
            Graph g = new Graph(nodes);

            //read edges
            while((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                int v1 = Integer.parseInt(tokens[0]);
                int v2 = Integer.parseInt(tokens[1]);


                //we add neighbor to each node in both directions.
                g.addNeighbor(v1, v2);
                g.addNeighbor(v2, v1);
            }

        }
        br.close();
    }
    catch(exceptions) {
        handle them
    }

}