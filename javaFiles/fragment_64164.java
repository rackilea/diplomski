String URL = exchange.getContext().resolvePropertyPlaceholders("{{URL_PAGO}}");

String PARAMS = "?param1=" + value1 + "&param2=" + value2;

ProducerTemplate producer = exchange.getContext().createProducerTemplate();
String response = producer.requestBody(URL + PARAMS, "", String.class);
producer.stop();