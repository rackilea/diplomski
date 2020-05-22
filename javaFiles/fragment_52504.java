System.out.println("Before blockingSubscribe");
System.out.println("Before Thread: " + Thread.currentThread());

Observable.interval(1, TimeUnit.SECONDS)
.take(5)
.blockingSubscribe(t -> {
     System.out.println("Thread: " + Thread.currentThread());
     System.out.println("Value:  " + t);
});

System.out.println("After blockingSubscribe");
System.out.println("After Thread: " + Thread.currentThread());