public Void call() {
    int i = 0;
    while (i < 3) {
            for (Future<Boolean> future : futures) {
                try {
                    if (future.get() == true && i == 0) {