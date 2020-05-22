Flux.just("1", "2", "3")
    .filter(s -> !s.equals("2"))
    .delayElements(Duration.ofMillis(500)) //this makes it stop printing in main thread
    .doOnNext(System.out::println)
    .subscribe(); 


Flux.just("1", "2", "3")
    .filter(s -> !s.equals("2"))
    .delayElements(Duration.ofMillis(500))
    .doOnNext(System.out::println)
    .blockLast(); //and that makes it printing back again