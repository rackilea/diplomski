public static void main(String[] args) {
        // TODO code application logic here
        int[] a = { 0, 1, 6, 83, 4, 5, 12, 7 };
        int[][] b = new int[4][4];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = 0;
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("--------------------------");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < b[i].length; j++) {
                try {
                    if ((j + i * 4) < a.length)
                        b[i][j] = a[j + i * 4];
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
    }