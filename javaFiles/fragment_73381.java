@ContextConfiguration( classes = TestConfig.class )
@RunWith(SpringJUnit4ClassRunner.class)
public class MyDAOTest {
    ...
}

@Import(AppConfig.class)
public class TestConfig {
    @Bean public Datasource getDatasource() throws Exception {...}
}

@Configuration
@ComponentScan( basePackages = {"com.acme"})
public class AppConfig {
    ....
}