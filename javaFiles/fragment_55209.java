final Supplier<Stream<Something>> provider = () -> someList.stream(); // and maybe more operations

new Thread(() -> {
    long result = provider.get()  // get an instance
       .mapToLong(something -> something.getSomeLong())
       .sum();
    someResultA.set(result);
}).start();

new Thread(() -> {
    double result = provider.get() // get another instance
         .mapToDouble(something -> (double) something.getSomeLong() / something.getAnotherLong())
         .sum();
    someResultB.set(result);
}).start();