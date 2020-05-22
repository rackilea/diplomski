public static int[] multiplicity(int[] nums) {
    // first pass
    int count = 0;
    for (int num : nums) {
        for (int i = 0; i < num; i++) {
            count++;
        }
    }
    int[] ret = new int[count];
    count = 0;
    // second pass
    for (int num : nums) {
        for (int i = 0; i < num; i++) {
            ret[count++] = num;
        }
    }
    return ret;
}