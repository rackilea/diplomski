for (int j = 0; j < numRows ; j++) {
    final int finalj = j;
    executor.execute(new Runnable() {
        public void run() {
            System.out.println(finalj);
        }
    });
}