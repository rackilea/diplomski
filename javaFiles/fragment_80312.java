// Lambda using Runnable
new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

Optional<String> opt = Optional.of("Meh");

// Lambda using Predicate<? super String>;
opt = opt.filter( s->s.equalsIgnoreCase("meh") ); 
System.out.println(opt+" <-- opt"); 

// Lambda using Consumer<? super String>;
opt.ifPresent( s->System.out.println(s) );

// Lambda using Function<? super String, ? extends String>;
opt = opt.map(s->s+"!").map(s->s+"!");
System.out.println(opt+" <-- opt");

// Lambda using Supplier<? extends IllegalArgumentException>;
opt.orElseThrow( ()->new IllegalArgumentException("Should not be empty.") );
opt = Optional.empty();
opt.orElseThrow(
    ()->new IllegalArgumentException("Empty?  Who said you could be empty?")
);

Thread-0
Optional[Meh] <-- opt
Meh
Optional[Meh!!] <-- opt
Exception in thread "main" java.lang.IllegalArgumentException: 
  Empty?  Who said you could be empty?
    at functionalinterfacestudy.AllLambdas.lambda$6(AllLambdas.java:110)
    at functionalinterfacestudy.AllLambdas$$Lambda$7/1392838282.get(Unknown Source)
    at java.util.Optional.orElseThrow(Unknown Source)
    at functionalinterfacestudy.AllLambdas.main(AllLambdas.java:110)