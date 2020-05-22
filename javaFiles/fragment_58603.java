int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;
for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {

                if (tab[i][j] < min) {
                    min = tab[i][j];
                }
                if (tab[i][j] > max) {
                    max = tab[i][j];
                }
            }

        }
System.out.println("min:" + min + ", max:" + max);