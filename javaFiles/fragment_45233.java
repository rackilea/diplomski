ArrayList<String> result;
Thread[] threads = new Thread[data.length];
SearchThread[] searchThreads = new SearchThread[data.length];

for (int i = 0; i < data.length; i++) {
    searchThreads[i] = new SearchThread(data[i]);
    threads[i] = new Thread(searchThreads[i]);
    threads[i].start();
}

try {
    for (int i = 0; i < data.length; i++) {
        threads[i].join();
        result.add(i, searchThreads[i].getResult() ? "found"
                : "not found");
    }
} catch (InterruptedException e) {
    // do something meaningful with your exception
}