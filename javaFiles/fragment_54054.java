Namespaces ns = new Namespaces("ct", "http://com/fr/test")
    .add("env", "http://www.w3.org/2003/05/soap-envelope");

from("activemq-ext-in:queue:" + queueName)
   .id("amq-transfert-downward-route")
   .filter(
      ns.xpath("/env:Envelope/env:Header/ct:equipmentType/text()='WCA'")
   ).to("activemq-ext-out:topic:" + topicName);