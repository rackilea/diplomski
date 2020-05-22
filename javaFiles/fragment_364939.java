int[][] table = { { 12, 0, 0, 0 ,99}, { 0, 0, 0, 0, 99}, { 0, 0, 0, 0, 99} };
int max = Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;

for (int i = 0; i < table.length; i++) {
    for (int k = 0; k < table[i].length; k++) {
        int val = table[i][k];
        if (val > max) {
            max = val;
        }
        if (val < min) {
            min = val;
        }
    }
}
System.out.println(max);
System.out.println(min);