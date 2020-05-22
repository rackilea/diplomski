@Service
class ServiceA {

    public void doService() {
        System.out.println("Doing ServiceA");
    }
}

@Service
class ServiceB {

    private ServiceA serviceA;

    public ServiceB() {
    }

    @Autowired
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void doService() {
        serviceA.doService();
    }
}