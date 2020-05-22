ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future<Integer>> list = new ArrayList<Future<Integer>>();

        for (int i = 0; i < 5; i++) {

            Future<Integer> future = executor.submit(new Callable<Integer>() {

                public Integer call() throws InterruptedException {

                    return Singleton.getInstance().hashCode();
                }
            });

            list.add(future);
        }

        executor.shutdown();

        Set<Integer> output = new HashSet<Integer>(); 
        for(Future<Integer> future : list){
            output.add(future.get());
        }

        System.out.println(output);