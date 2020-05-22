observable = Observable.interval(100, TimeUnit.MILLISECONDS)
            .map(aLong -> {
                System.out.println("1");
                return aLong;
            })
            .map(aLong -> {
                observable.dispose();
                System.out.println("2");
                return aLong;
            })
             .map(aLong -> {
                 observable.dispose();
                 System.out.println("3");
                 return aLong;
             })
             .doOnNext(aLong -> System.out.println("4"))
             .map(aLong -> {
                 observable.dispose();
                 System.out.println("5");
                 return aLong;
             })
            .subscribe();
}