ModelCamelContext context = new DefaultCamelContext();
context.setStreamCaching(true); //!!
// ...

from("direct:start")
    .to("http://ip.jsontest.com/?callback=showMyIP")
    .process(new MyProcessor())
    .process(new MyProcessor());