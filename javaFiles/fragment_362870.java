class PathAndWord {
    final String path;
    final String whatFind;

    PathAndWord(String path, String whatFind) {
        this.path = path;
        this.whatFind = whatFind;
    }

    boolean isProperlyInitialized() {
        return path != null && whatFind != null;
    }
}

public void askUserPathAndWord() {
    try {
        tryToAskUserPathAndWord();
    } catch (IOException | RuntimeException e) {
        System.out.println("Wrong input!");
        e.printStackTrace();
    } catch (InterruptedException e) {
        System.out.println("Interrupted.");
        e.printStackTrace();
    }
}

private void tryToAskUserPathAndWord() throws IOException, InterruptedException {
    PathAndWord pathAndWord = readPathAndWord();

    if (pathAndWord.isProperlyInitialized()) {
        performScan(pathAndWord, "GameOver.tmp");
        System.out.println("Thank you!");
    } else {
        System.out.println("You did not enter anything");
    }
}

private PathAndWord readPathAndWord() throws IOException {
    System.out.println("Please, enter a Path and Word (which you want to find):");

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String path = readPath(bufferedReader);
    String whatFind = readWord(bufferedReader);
    return new PathAndWord(path, whatFind);
}

private String readPath(BufferedReader bufferedReader) throws IOException {
    System.out.println("Please enter a Path:");
    return bufferedReader.readLine();
}

private String readWord(BufferedReader bufferedReader) throws IOException {
    System.out.println("Please enter a Word:");
    return bufferedReader.readLine();
}

private void performScan(PathAndWord pathAndWord, String endOfWorkFileName) throws InterruptedException {
    BlockingQueue<File> queue = new LinkedBlockingQueue<File>();

    File endOfWorkFile = new File(endOfWorkFileName);
    CountDownLatch latch = new CountDownLatch(2);

    FolderScan folderScan = new FolderScan(pathAndWord.path, queue, latch,
            endOfWorkFile);
    FileScan fileScan = new FileScan(pathAndWord.whatFind, queue, latch,
            endOfWorkFile);

    Executor executor = Executors.newCachedThreadPool();
    executor.execute(folderScan);
    executor.execute(fileScan);

    latch.await();
}