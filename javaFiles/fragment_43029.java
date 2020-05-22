static void process(int[] array) {
    int n = array.length;
    if (n < 2) return;

    int[] maxLeft = new int[n];
    maxLeft[0] = array[0];
    for (int i = 1; i < n; ++i) {
        maxLeft[i] = Math.max(maxLeft[i-1], array[i]);
    }  

    int minRight = array[array.length-1];
    for (int i = n-2; i >= 0; --i) {
        if (maxLeft[i] < minRight) {
            System.out.println("index = " + i + ", element = " + array[i]);
            return;
        } 
        minRight = Math.min(minRight, array[i]); 
    }
}