String tryToReadFile(File f) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
        if (f.exists())
            return readFile(f);
        Thread.sleep(1000);
    }
    return null;
}