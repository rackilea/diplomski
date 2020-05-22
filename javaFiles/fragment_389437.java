int a[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};

        for (int i = 0; i < a.length; i++) {
            System.out.print("---> It is going to read colmuns in order to make a line");
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("-->It is going to make a new next line");
        }