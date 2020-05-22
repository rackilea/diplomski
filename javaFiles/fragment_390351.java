final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    final List<Future<?>> futures = new ArrayList<>();

    public int[][] matriz = new int[3000][3000];



    public void parallelSearch() {
        long startTime = System.currentTimeMillis();
        matriz[1580][1] = 9;

        executor.submit( () -> search( 0, 500, startTime) );
        executor.submit( () -> search( 500, 1000, startTime) );
        executor.submit( () -> search( 1000, 1500, startTime) );
        executor.submit( () -> search( 1500, 2000, startTime) );
        executor.submit( () -> search( 2000, 2500, startTime) );
        executor.submit( () -> search( 2500, 3000, startTime) );
    }

    public void search(int startRow, int endRow, long startTime){
        for (int i = startRow ; i < endRow; i++) {
            //add some execution time to justify parallel processing
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (int j = 0; j < 3000; j++) {
                int x = i;
                int z = j;

                if(matriz[x][z] == 9) {
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;

                    System.out.println("NOW parallel "+ x + "|" + z+ ": "  + elapsedTime);
                }
            }
        }
    }

    public void search() {
        long startTime = System.currentTimeMillis();
        int biggest = 0;

        for (int i = 0 ; i < 3000; i++) {

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (int j = 0; j < 3000; j++) {

                if( matriz[i][j] == 9 ) {

                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;

                    System.out.println("NOW normal "+ i + "|" + j + ": "  + elapsedTime);
                }
            }
        }


    }