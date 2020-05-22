@Configuration
@EnableConfigurationProperties(SurveyProperties.class)
    static class Config {
}


@ContextConfiguration(classes = {
        SurveyPublisherTest.Config.class })
@TestPropertySource(properties = { "com.test.survey.request-max-limit=1.00" })
public class SurveyPublisherTest extends AbstractTestNGSpringContextTests {

//Remove this mock
//@Mock
//SurveyProperties surveyProperties;
}