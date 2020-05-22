String URL = exchange.getContext().resolvePropertyPlaceholders("{{URL_PAGO}}");

String PARAMS = "param1=" + value1 + "&param2=" + value2;
Map<String,Object> headers = new HashMap<String,Object>();
headers.put(Exchange.HTTP_QUERY, PARAMS);

ProducerTemplate producer = exchange.getContext().createProducerTemplate();
String response = producer.requestBody(URL, "",headers, String.class);
producer.stop();