int[][] array = { {1,2,3}, {4,5,6}, {7,8,9}, {10,11,12,13,14,15} };

ExecutorService threadPool = Executors.newFixedThreadPool(array.length);
for(int i = 0; i < array.length; i++) {
    final int finalI = i;
    threadPool.submit(() -> {
        int[] row = array[finalI];
        System.out.println(Thread.currentThread().getName() + ": " + Arrays.toString(row));
        for(int j = 0; j < row.length; j++) {
            row[j] *= 2;
        }
    });
}

threadPool.shutdown();
while(!threadPool.isTerminated()) {
    Thread.sleep(20);
}

for(int i = 0; i < array.length; i++) {
    int[] row = array[i];
    for(int j = 0; j < row.length; j++) {
        System.out.print(row[j] + ", ");
    }
    System.out.println();
}