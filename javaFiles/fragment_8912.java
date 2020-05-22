static int[][] processedArrayData = new int[3][];
static int idx = 0;

public static void processArrays(int[] incoming) {
    processedArrayData[ idx++ ] = incoming;
}