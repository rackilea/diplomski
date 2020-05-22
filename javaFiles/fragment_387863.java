mock.whenAnyExchangeReceived(new Processor() {
        public void process(Exchange exchange) throws Exception {

            MyPojo myPojo = exchange.getIn().getBody(MyPojo.class);
            boolean status =//custom pojo equals logic;

            exchange.getIn().setBody(status);
        }
    });
    boolean out = template.requestBody(url, new MyPojo(), Boolean.class);
    assertEquals(true, out);