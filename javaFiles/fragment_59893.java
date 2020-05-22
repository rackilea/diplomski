from("{{somewhere.in.endpoint}}")
   .choice()
      .when(header("endOnExceptionFlag").isEqualTo(true))
         .to("direct:splitEndOnException")
      .otherwise()
         .to("direct:splitIgnoreExceptions")
   .endChoice()
.end()

// process split with exception handling
.from("direct:splitEndOnException")
   .split().method(MySplitter.class).stopOnException().shareUnitOfWork()
      .to("direct:processEachSubExchange")
.end();

// process split ignoring exceptions
.from("direct:splitIgnoreExceptions")
   .split().method(MySplitter.class).shareUnitOfWork()
      .to("direct:processEachSubExchange")
.end();