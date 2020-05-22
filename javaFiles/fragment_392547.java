@Service
public class DetailsQuery {

  private final RestTemplate restTemplate;

  @Autowired
  public DetailsQuery (RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.additionalMessageConverters(new MappingJackson2HttpMessageConverter()) build();
  }

  ....
}