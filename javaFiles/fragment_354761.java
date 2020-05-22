Future<?> future = executor.submit(libDownloader);

while (!future.isDone()) {
    //bad spin wait
} 

executor.execute(resDownloader);