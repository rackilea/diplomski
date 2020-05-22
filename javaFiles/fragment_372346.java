from("timer://runOnce?repeatCount=1&delay=10")
    .bean(myPOJOFactory.class)
    .multicast().to("direct:sendFizz", "direct:sendBuzz")

from("direct:sendFizz")
    .setBody(simple("${body.fizz"))
    .to("direct:fizzFarm")

from("direct:sendBuzz")
    .setBody(simple("${body.buzz"))
    .to("direct:buzzFarm")