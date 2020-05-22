for (int j = 0; j < line.length; j++){  
       if(j % 4 == 0 ){ //Input: vertex weight vertex weight: 1 1 2 3
        int vert = Integer.parseInt(String.valueOf(line[j]));
        int w = Integer.parseInt(String.valueOf(line[j+2]));
        v[i].adjacencies = new Edge[] {new Edge(v[vert], w)};
    }