public void max1() {
    double[] max_values = new double[cur[0].length];
    for (int i = 0; i < cur[0].length; i++) { // i should be your column
        double max = cur[0][i];// assign 1st value of the column as max
        for (int j = 0; j < cur.length; j++){ // j is your row
           if (cur[j][i] > max){ 
              max = cur[j][i];// get the column values 
           }
        }
        max_values[i] = max;
    }