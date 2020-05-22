final MockEndpoint mock = getMockEndpoint("mock:result");
    mock.expects(new Runnable() {
        public void run() {

            MyPojo myPojo = mock.getExchanges().get(0).getIn().getBody(MyPojo.class);
            boolean status = //custom pojo equals logic;
            if(!status){
                fail("Testcase fails");
            }
        }
    });