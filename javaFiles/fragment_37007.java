@Bean
public RestTemplate template() {
    return new RestTemplate();
}
@Autowired
private RestTemplate template;