Set<String> submitted = Collections.synchronizedSet(new HashSet<String>());
    ExecutorService executorService = Executors.newFixedThreadPool(10); // how many threads to work with it

    for(final String sourceFolder : foldersPaths){
        if(! submitted.contains(sourceFolder)) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    transferFolder(...); // your method invoked here
                }
            };
            if (submitted.add(sourceFolder)) {
                executorService.submit(runnable);
            }
        }
    }
    executorService.shutdown();