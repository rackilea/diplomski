@ActiveProfiles("test")
//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestExample.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Test.CustomConfiguration.class})
public class Test {

    @Configuration
    @EnableConfigurationProperties
    @EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class,
            JpaRepositoriesAutoConfiguration.class,
            DataSourceAutoConfiguration.class,  
            EurekaClientAutoConfiguration.class})
    static class CustomConfiguration {

    }

    @Test
    public void test() {
        System.out.println("success!");
    }
}