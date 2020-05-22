public void process(Exchange exchange) throws Exception {
    List<Object> list = new ArrayList<Object>();
    list.add( xml1 );
    list.add( xml2 );
    exchange.getIn().setBody( list );
}