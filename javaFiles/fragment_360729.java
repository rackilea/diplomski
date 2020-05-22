final File file = null; // get file somehow
    final DataOutputStream dos = new DataOutputStream(
       new BufferedOutputStream(new FileOutputStream(file), 8192));
    try {
        for (int x: ....) { //loop through your matrix (might be different if matrix is sparse)
           for (int y: ....) {
               if (matrix[x,y] != 0.0) {
                   dos.writeInt(x);
                   dos.writeInt(y);
                   dos.writeDouble(matrix[x,y]);                                     
               } 
           }
        }
     } finally {
       dos.writeInt(-1); // mark end (might be done differently)
       dos.close();
     }