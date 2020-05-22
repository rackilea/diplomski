class ServiceA {

    public void doService() {
        System.out.println("Doing ServiceA");
    }
}

class ServiceB {

    private final ServiceA serviceA;

    ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void doService() {
        serviceA.doService();
    }
}

@Configuration
class ServiceConfig{

    @Bean
    public ServiceA serviceA(){
        return new ServiceA();
    }   

    @Bean
    public ServiceB serviceB(ServiceA serviceA){
        return new ServiceB(serviceA);
    }
}