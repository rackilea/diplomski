class SampleRoute extends RouteBuilder {

    @Override
    public void configure() {
        try
        {
            from("direct:consumerMethod").process(new DDT());
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}