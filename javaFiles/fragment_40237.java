public static void main(String[] args) {
    int[][] num = {// 0  1  2  3
            {4, 6, 9, 3},
            {6, 2, 4, 1},
            {8, 3, 7, 9}
    };
    int[] total = new int[num[0].length];

    for (int i=0; i < total.length;i++){
        total[i] = 0;
    }


    for (int i = 0; i < num.length; i++) {
        for (int j = 0 ; j < total.length; j++) {
            total[j] += num[i][j];
        }
    }

    for (int i=0; i < total.length;i++){
        total[i] = Math.abs(total[i]);
    }

    int max = 0;
    for (int i=0; i < num.length;i++){
        if (max < total[i])
            max = total[i];
    }
    System.out.println("max : " + max);
}