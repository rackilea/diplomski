private Path directory;

.....        
private Task<ObservableList<Integer>> createWorker() {

    return new Task<ObservableList<Integer>>() {
        @Override
        protected ObservableList<Integer> call() throws Exception {
            Stack<Path> stack = new Stack();
            stack.push(directory);
            int i = 0;
            while (!stack.empty()) {
                if (isCancelled()) {
                    break;
                }
                Path root = stack.pop();
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(root);) {
                    for (Path path : stream) {
                        if (Files.isDirectory(path)) {
                            stack.push(path);
                        } else {

                            if (path.toString().endsWith(".pdf")) {
                                i++;
                                results.add(i);
                                updateProgress(i, 100);
                                updateValue(results);
                                Thread.sleep(5);
                            }
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
            return results;
        }

    };

}