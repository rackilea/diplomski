public String superLongMethod() {
  System.out.println("superLongMethod");
  Thread.sleep(10000);
  return "ok";
}

System.out.println("before");
Mono.just(superLongMethod());
System.out.println("after");

// printed output is - before - superLongMethod - after

-----------------------------------------------------------------

System.out.println("before");
Mono.fromCallable(() -> superLongMethod());
System.out.println("after");

// printed output is - before - after - superLongMethod

-----------------------------------------------------------------

System.out.println("before");
String key = superLongMethod();
System.out.println("after");
return getValueFromRedis(key);

// printed output is - before - superLongMethod - after

-----------------------------------------------------------------

System.out.println("before");
Mono<String> mono = Mono.fromCallable(() -> {
  String key = superLongMethod();
  return getValueFromRedis(key);
}).flatMap(stringMono -> stringMono);
System.out.println("after");
return mono;

// printed output is - before - after - superLongMethod