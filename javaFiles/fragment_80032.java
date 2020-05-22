from("activemq:queue:input?concurrentConsumers=1&maxConcurrentConsumers=1")
    .to("direct:step1");

from("direct:step1")
    //perform step1 processing
    .to(direct:step2");

from("direct:step2")
    //perform step2 processing
    .to(direct:step3");
...