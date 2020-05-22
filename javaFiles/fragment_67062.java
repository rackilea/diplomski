class Scanner implements Callable<Boolean> {
    ....

    @Override
    public Boolean call() {
        try {
            ....
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}

ExecutorService ex = Executors.newCachedThreadPool();
List<Scanner> tasks = new ArrayList<>();
for (int i = 78; i < 85; i++) {
    tasks.add(new Scanner("google.com", i));
}
List<Future<Boolean>> list = ex.invokeAll(tasks);
for(int i = 0; i < tasks.size(); i++) {
    if (list.get(i).get()) {
        System.out.printf("Port is in use: %d", tasks.get(i).port());
    } else {
        System.out.printf("Port is not in use: %d", tasks.get(i).port());
    }
}
// dont forget to shutdown executor
ex.shutdown();