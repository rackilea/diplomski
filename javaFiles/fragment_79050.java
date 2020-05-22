RxObserver observer = new RxObserver();
try {

    CountDownLatch cdl = new CountDownLatch(1);

    observer.getObservable()
           .observeOn(Schedulers.io())
           .subscribe( x ->System.out.println(x),
                       t -> { System.out.println(t); cdl.countDown(); },
                       () -> { System.out.println("Completed"); cdl.countDown(); });

    cdl.await();
 } catch (IOException | InterruptedException e) {
     e.printStackTrace();
 }