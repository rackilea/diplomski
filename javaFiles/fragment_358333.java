public static void main(String[] args) {
    File test = new File(System.getProperty("user.home"), "test.txt");
    int lineCount = countLines(test);
    int[] nums = new int[lineCount];
    String[] vals = new String[lineCount];
    readLines(test, nums, vals);
    for (int j = 0; j < lineCount; j++) {
        System.out.printf("%s:%d%n", vals[j], nums[j]);
    }
}