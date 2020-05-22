from( "direct:start" ).process( new Processor() {
        @Override
        public void process( Exchange e) throws Exception {
            final BeanInvocation bi = e.getIn().getBody( BeanInvocation.class );
            e.getIn().setBody( bi.getArgs() );
        }
    } ).to( "cxf:bean:cxfEndpoint" )