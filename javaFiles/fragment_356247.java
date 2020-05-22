@Bean
@Qualifier("special")
class MyBean {}

@Bean
class OtherBean {
    @Qualifier("special")
    private MyBean bean;
}