for (int i=0; i<sizeI(); i++) 
{
  for (int j=0; j<sizeJ(); j++) 
  {
     if(maze[i][j]=='0')
          maze[i][j]='C';
     if(maze[i][j]=='1')
          maze[i][j]='X';
     if(i==1 && j==3)
          maze[i][j]='S';
     if(i==21 && j==23)
          maze[i][j]='E';
  }
}