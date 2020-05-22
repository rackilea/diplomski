DDTConsumer ddt;
try {
    ddt = new ProxyBuilder(camelContext).endpoint("direct:consumerMethod").build(DDTConsumer.class);
    ddt.sendMessage(msg.getValue());
    } catch (Exception e) {
        e.printStackTrace();
    }