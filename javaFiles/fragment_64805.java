List<Document> processDocs(String filePath) {
    List<Callable<Document>> tasks = new ArrayList<>();
    try {
        BufferedReader br = new BufferedReader(IOUtils.fileReader(filePath));

        String line = null;
        while ((line = br.readLine()) != null) {
            tasks.add(new NLPTextThread(line.trim());

        }
        ExecutorService executor = Executors.newfixedThreadPool(4);

        return executor.invokeAll(tasks)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).collect(Collectors.toList());
    }