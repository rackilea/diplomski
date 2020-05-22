public static void main(String[] args) {
    String [][] val = {{"r1c1", "r1c2", "r1c3"},
            {"r2c1", "r2c2", "r2c3"},
            {"r3c1", "r3c2", "r3c3"}};
    for(int row =0;row <val.length; row++){
        for(int col =0;col <val[0].length; col++){
            System.out.print(val[row][col]+" ");
        }
        System.out.println();
    }
    System.out.println("**NEXT**");
    for(int col =0;col <val[0].length; col++){
        for(int row =0;row <val.length; row++){
            System.out.print(val[row][col]+" ");
        }
        System.out.println();
    }
}