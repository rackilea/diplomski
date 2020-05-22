public static float[][] toFloatArray(String s){
    String [] array = s.replaceAll("[\\[ ]+", "").split("],");

    float [][] floatArray = new float[array.length][];

    for(int i = 0; i < array.length; i++){
        String [] row = array[i].split("\\D+");
        floatArray[i] = new float[row.length];
        for(int j = 0; j < row.length; j++){
            floatArray[i][j] = Float.valueOf(row[j]);
        }           
    }

    return floatArray;
}