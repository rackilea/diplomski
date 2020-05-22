while(queue.peek()!=null){
        int[]array=queue.poll();
        int x=array[0];int y=array[1];

        if(x<0||y<0||y>n-1||x>n-1)continue;
        if(maze[x][y]=='#')continue;
        if(maze[x][y]=='*'){                 
            candy++;               
            minsteps=array[2];
            maze[x][y]='.';
        }
        if(maze[x][y]>='a'&&maze[x][y]<='f'){
            if(candy <maze[x][y]-'a'+1)continue;
        }
        int[][]points = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<4;++i){
            int sta[]={x+points[i][0],y+points[i][1],array[2]+1};
            queue.add(sta);
        }
       maze[x][y]='#'; // <== this part is wrong
    }