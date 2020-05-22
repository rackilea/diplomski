public static void transpose( int mn[][] ){
    int nm[][] = new int[mn[0].length][mn.length]; // use the values from mn
    for( int i = 0; i < 5; i++ ){
        for( int j = 0; j < 3; j++ ){
            nm[i][j] = mn[j][i];
            System.out.println(nm[i][j] + "   " + "/n");
        }
    }
}