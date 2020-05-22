public int distance(Vertex x, Vertex y){
        Queue<Vertex> search = new LinkedList<Vertex>();
        search.add(x);
        while(!search.isEmpty()){
            Vertex t = search.poll();
            if(t == y){
                return pathLength( t );
            }
            for(Vertex n: t.neighbours){
                if(n.cameFrom == null || n != x){
                    n.cameFrom = t;
                    search.add(n);
                }

            }
            System.out.println(search + " " + t);
        }
        return -1;  
    }

    public int pathLength( Vertex v )
    {
       int path = 0;

       while ( v.cameFrom != null )
       {
         v = v.cameFrom;
         path++;
       }

       return path;
    }