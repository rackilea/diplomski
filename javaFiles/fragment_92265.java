ExecutorService executorService = Executors.newFixedThreadPool(5);
    List<Future<Void>> handles = new ArrayList<Future<Void>>();
    Future<Void> handle;
    for (int i=0;i < 12; i++) {
        handle = executorService.submit(new Callable<Void>() {

            public Void call() throws Exception {
                Document d = Jsoup.connect("http://www.google.hr").timeout(0).get();
                System.out.println(d.title());
                return null;
            }
        });
        handles.add(handle);
    }

    for (Future<Void> h : handles) {
        try {
            h.get();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    executorService.shutdownNow();