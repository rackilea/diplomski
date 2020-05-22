public class ReplacePatterns {

    //replace every instance of the pattern a with the pattern b inside c.
    //find a way to get the dimensions of a 2D array
    public static int[][] replace(int[][] a, int[][] b, int[][] c){
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[0].length; j++){
                if(c[i][j] == a[0][0]){ //c[i][j] should match up with a[0][0].
                    // Start verifying the rest of A
                    boolean flag = true;
                    for (int k = 0; k < a.length; k++) {
                        for (int l = 0; l < a[k].length; l++) {
                            if ((i+k) >= c.length || (j+l) >= c[0].length) {
                                flag = false;
                                break;
                            }
                            if (c[i+k][j+l] != a[k][l]) {
                                flag = false;
                            }
                        }
                    }
                    // If all the values for A were exactly the same, then replace it all with whatever is in B
                    if (flag) {
                        for (int k = 0; k < a.length; k++) {
                            for (int l = 0; l < a[k].length; l++) {
                                c[i+k][j+l] = b[k][l];
                            }
                        }
                    }
                }
            }
        }
        return c;
    }

    public static String prettyPrint(int[][] c) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[0].length; j++){
                sb.append("[" + c[i][j] + "]");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void test(int[][] patternA, int[][] patternB, int[][] patternC) {
        System.out.println("Pattern A:");
        System.out.println(prettyPrint(patternA));
        System.out.println("Pattern B:");
        System.out.println(prettyPrint(patternB));
        System.out.println("  Array C:");
        System.out.println(prettyPrint(patternC));

        int[][] result = ReplacePatterns.replace(patternA, patternB, patternC);

        System.out.println("  Result:");
        System.out.println(prettyPrint(result));
    }

    public static void main(String[] args){
        int[][] patternA, patternB, patternC;

        System.out.println("Test1:");
        patternA = new int[][]{{1,1}, {1,1}};
        patternB = new int[][]{{3,3}, {3,3}};
        patternC = new int[][]{{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        test(patternA, patternB, patternC);

        System.out.println("Test2:");
        patternA = new int[][]{{1,1}, {1,1}};
        patternB = new int[][]{{5,6}, {7,8}};
        patternC = new int[][]{{0,1,1,1,0,1}, {1,1,1,0,1,1,1}, {0,1,1,1,1,1,1}};
        test(patternA, patternB, patternC);
    }
}