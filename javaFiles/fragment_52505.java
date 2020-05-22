System.out.println("Before subscribe");
System.out.println("Before Thread: " + Thread.currentThread());

Observable.timer(1, TimeUnit.SECONDS, Schedulers.io())
.concatWith(Observable.timer(1, TimeUnit.SECONDS, Schedulers.single()))
.subscribe(t -> {
     System.out.println("Thread: " + Thread.currentThread());
     System.out.println("Value:  " + t);
});


System.out.println("After subscribe");
System.out.println("After Thread: " + Thread.currentThread());

// RxJava uses daemon threads, without this, the app would quit immediately
Thread.sleep(3000);

System.out.println("Done");