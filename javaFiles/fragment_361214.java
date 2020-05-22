public class CustomTestInitializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    CustomService customService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      // TODO: implement you loginc
    }
}