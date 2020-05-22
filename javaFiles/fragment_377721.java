int sqSize = 50;  
int gridSize = 500; 
int n;  [![enter image description here][1]][1]
int[][] grid; 

public void setup()
{
  size(500, 500);  
  noLoop();  
  n = gridSize/sqSize; 
  grid = new int[n][n];

  ellipseMode(CORNER);
}

void draw()
{
  for (int row = 0; row < n; row++) {
    for (int col = 0; col < n; col++) {
      stroke(0);
      if ( (row % 2) == (col % 2) )
      {
        fill(255, 0, 0); 
        rect(row*sqSize, col*sqSize, sqSize-2, sqSize-2);
      } else {
        fill(0, 0, 0); 
        rect(row*sqSize, col*sqSize, sqSize-2, sqSize-2); 
        fill(255);
        ellipse(row*sqSize, col*sqSize, sqSize-2, sqSize-2);
        //this is what I tried, but failed.
      }
    }
  }
}