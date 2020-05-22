List<String> filePathsInOrder = new ArrayList<>();
        List<Future<String>> fileOutputsInOrder = new ArrayList<>();
        for (String filePath : filePathsInOrder) {
            fileOutputsInOrder.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return Files.readString(Paths.get(filePath));
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        for (Future<String> fileOutput : fileOutputsInOrder){
            System.out.println(fileOutput.get());
        }