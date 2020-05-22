@Configuration
public class AppConfig {

    @Autowired
    private TopicGenerator cppTopicGenerator;

    @Autowired
    private TopicGenerator phpTopicGenerator;

    @Autowired
    private TopicGenerator javaTopicGenerator;

    @Bean
    public List<TopicGenerator> topicGeneratorList()
    {
        return Arrays.asList(cppTopicGenerator, phpTopicGenerator, javaTopicGenerator);
    }
}