@Autowired
   MyServiceFactory myServiceFactory;

    @Override
    public void run(String... strings) throws Exception {
        myServiceFactory.getMyServiceByName("myService").sayHello();
        myServiceFactory.getMyServiceByName("myService2").sayHello();
    }