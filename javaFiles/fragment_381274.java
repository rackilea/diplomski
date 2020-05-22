public void setElement (int i, int j, int n) {
     // 1 - Get a copy of the original matrix   
     getField() 
                // 2 - Change an element of the copy                                
                [i][j] = n;

              // 3.a - get a copy of the original matrix
     // 3.b - Set the copy                      
     setField(getField());
}