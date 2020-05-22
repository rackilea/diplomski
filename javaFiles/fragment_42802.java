int res = 0;
    for (i=0; i<8; i++) {
        for (j=0; j<5; j++) {
            System.out.print(A[i][j] + "\t");
            if (A[i][j] >= 250) res++;
        }
        System.out.println();
    }

    System.out.println("results: " + res);