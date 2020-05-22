char[] a = { 'a', 'b', 'c', 'd' };
        for (int i = 0; i < (a.length*2); i++) {
            if (i < a.length) {
                for (int j = 0; j < a.length; j++) {
                    System.out.print(a[j]);
                    if (j == i)
                        System.out.print(" ");
                }
                System.out.println("");
            } else {
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k]);
                    if (k != (i - (a.length + 1)))
                        System.out.print(" ");
                }
                System.out.println("");
            }
        }