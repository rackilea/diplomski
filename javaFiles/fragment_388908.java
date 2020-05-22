public class FizzFuzz {
    @Inject
    @Named("red")
    private String service;

    public static void main(String[] args) {
        FizzFuzz fizzFuzz = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bindConstant().annotatedWith(Names.named("red")).to("red-service");
            }    
        }).getInstance(FizzFuzz.class);

        System.out.println(fizzFuzz.service);
    }
}