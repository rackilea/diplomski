public void bfs(Vertex rootNode){

        Queue q = new LinkedList();
        q.add(rootNode);
        rootNode.visited=true;
        while(!q.isEmpty()){
            Vertex n = (Vertex)q.poll();
            System.out.print(n.toString() + " ");
            for(Edge edge : n.getNeighbors()){
                Vertex adj = edge.getNeighbor(n);
                if(!adj.visited){
                    adj.visited=true;
                    q.add(adj);
                }
            }
        }

}