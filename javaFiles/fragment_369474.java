for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                for (x = Math.max(0, i - 1); x <= Math.min(i + 1, array.length); x++) {
                    for (y = Math.max(0, j - 1); y <= Math.min(j + 1,
                            array[i].length); y++) {
                        if (x >= 0 && y >= 0 && x < array.length
                                && y < array[i].length) {
                            if(x!=i || y!=j){
                            System.out.print(array[x][y] + " ");
                            }
                        }
                    }
                }
                System.out.println("\n");
            }
        }