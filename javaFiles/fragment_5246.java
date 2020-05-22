Vertex[] v = new Vertex[20]; // 20 vertices in the grid
for(int row = 0; row < numrows; row++) // numrows = 4
{
  int rowoffset = row * numcols ; //0, 4, 8, 12
  for(int col = 0; col < (numcols - 1); col++) //numcols = 5
  {
     addLineIndices(rowoffset + col, rowoffset + col +1); //adds (0,1), (1,2), (2,3) and (3, 4) for the first row
  }
}