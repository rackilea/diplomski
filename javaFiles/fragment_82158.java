public void searchStringInFile(String directory, String word){
    if (word == null || directory == null) {
        return;
    }

    File filePath = new File(directory);
    Queue<File> queue = new ConcurrentLinkedQueue<>();
    queue.add(filePath);

    while (!queue.isEmpty()) {
        File currentFile = queue.poll();
        File[] listOfDirectories = currentFile.listFiles();

        if (listOfDirectories != null)
        {
            new Thread(() -> {
                for (File file : listOfDirectories)
                {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else {
                       readText(file, word);
                    }
                }
            }).start();

        }
    }
}