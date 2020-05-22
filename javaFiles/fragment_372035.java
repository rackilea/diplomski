executorService.invokeAll(tasks.stream().map(task -> new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    // run task;
                    return null;
                }
            })
.collect(Collectors.toList()));