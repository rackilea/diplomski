@TestConfiguration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.sample", repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class ApplicationConfigurationTest {

}

@DataJpaTest
@Import(ApplicationConfigurationTest.class) 
public class AccountRespositoryTest {

    @Autowired
    private TestEntityManager entityManager;