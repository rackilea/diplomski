double[][] matrix = new double[][]{
    {0.70,0.75,0.70,0.75,0.80},
    {0.55,0.30,0.20,0.10,0.70},
    {0.80,0.10,0.00,0.00,0.80},
    {0.70,0.00,0.00,0.00,0.80},
    {0.80,0.90,0.80,0.75,0.90}};

double cx = 0;
double cy = 0;
double m = 0;

for(int x = 0; x < matrix.length; x++ ) {
  for(int y = 0; y < matrix[x].length; y++) {
    cx += matrix[x][y] * x;
    cy += matrix[x][y] * y;
    m += matrix[x][y];
  }
}

//those are center's the cell coordinates within the matrix
int cmx = (int)(cx/m); 
int cmy = (int)(cy/m);

//whatever you'd need that value for (the position is more likely what you're after)
double centerOfMassValue = matrix[cmx][cmy];