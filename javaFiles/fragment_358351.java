public MyEJBService buildMyEJBService() {
    MyEJBInterface myEjb = new JndiLookupHelper<MyEJBInterface>().lookup(MyEJBInterface.JNDI_NAME);

    MyEJBService service = new MyEJBServiceMock(myEjb);

    return service;
}