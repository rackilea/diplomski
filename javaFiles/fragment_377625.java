System.out.println("Look here " + sales[4][2]);

        double[][] salesByColumn = new double[maxColumns][];
        for(int i = 0; i < maxColumns; i++) {
            salesByColumn[i] = new double[(sales.length)];
            for(int j = 0; j < sales.length; j++) {
                System.out.println("Assigning "+i+", "+j+" to" +sales[j][i]);
                salesByColumn[i][j] = sales[j][i];
            }
        }