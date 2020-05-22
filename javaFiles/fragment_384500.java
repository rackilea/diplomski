public void visit(String []map , Point start){
        int []x = {0,0,1,-1};//This represent 4 directions right, left, down , up
        int []y = {1,-1,0,0};
        LinkedList<Point> q = new LinkedList();
        q.add(start);
        int n = map.length;
        int m = map[0].length();
        int[][]dist = new int[n][m];
        for(int []a : dist){
            Arrays.fill(a,-1);
        }
        dist[start.x][start.y] = 0;
        while(!q.isEmpty()){
            Point p = q.removeFirst();
            for(int i = 0; i < 4; i++){
                int a = p.x + x[i];
                int b = p.y + y[i];
                if(a >= 0 && b >= 0 && a < n && b < m && dist[a][b] == -1 && map[a].charAt(b) != '*' ){
                    dist[a][b] = 1 + dist[p.x][p.y];
                    q.add(new Point(a,b));
                }
            }
        }
    }