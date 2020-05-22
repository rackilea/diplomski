String[][] allOps = new String[64][3];
    int count = 0;
    for (int x = 0; x < 4; x++) {
        for (int y = 0; y < 4; y++) {
            for (int z = 0; z < 4; z++) {
                allOps[count][0] = ops[x];
                allOps[count][1] = ops[y];
                allOps[count][2] = ops[z];
                count++;
            }
        }
    }
    System.out.println(count);
    System.out.println(Arrays.deepToString(allOps));