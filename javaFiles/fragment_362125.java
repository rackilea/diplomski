int find(int x,int y,int h)
{    
    int result = -1;
    if   ((x+1<rows && m[x+1][y].c=='@'   &&  !m[x+1][y].done) 
        ||(x-1>=0   && m[x-1][y].c=='@'   &&  !m[x-1][y].done)
        ||(y+1<cols && m[x][y+1].c=='@'   &&  !m[x][y+1].done)   
        ||(y-1>=0   && m[x][y-1].c=='@'   &&  !m[x][y-1].done)){   
        return h + 1;
         }
      else
       {

        if(x-1>=0   &&  m[x-1][y].c=='1' && !m[x-1][y].done){   /*north cell*/
                   m[x][y].done=true;

                   result = find(x-1,y,h + 1)
                   if (result > -1) {
                       return result; 
                   }
                   m[x][y].done=false;
        }