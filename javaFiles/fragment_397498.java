Edge[] edges = new Edge[line.length/4];  
    for (int j = 0; j < line.length; j++){           
       if(j % 4 == 0 ){ //Input: vertex weight vertex weight: 1 1 2 3
        int vert = Integer.parseInt(String.valueOf(line[j]));
        int w = Integer.parseInt(String.valueOf(line[j+2]));
        edges[j/4] =  {new Edge(v[vert], w)};
    }
   v[i].adjacencies = edges;