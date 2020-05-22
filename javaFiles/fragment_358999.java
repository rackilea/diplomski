@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserDetailsFacadeTest {
  @TestConfiguration
  public static class UserDaoTestConfiguration {
    @Bean
    public UserDetailsFacade getUserDao(EntityManager entityManager) {
      return new UserDetailsFacade(entityManager);
    }
  }

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserDetailsFacade userDetailsFacade;

  @BeforeEach
  public void setUp() {
    User tom = new User();
    User dick = new User();
    User sally = new User();

    tom.setAge(17);
    dick.setAge(40);
    sally.setAge(35);

    tom.setChildren(0);
    dick.setChildren(1);
    sally.setChildren(0);

    tom.setSalary(240);
    dick.setSalary(40000);
    sally.setSalary(40000);

    userRepository.save(tom);
    userRepository.save(dick);
    userRepository.save(sally);
  }

  @Test
  public void testGetExpectedSummedSallary() {
    AggregatedUserDetails aggregatedUserDetails = userDetailsFacade.aggregatedUserDetails();
    assertThat(aggregatedUserDetails.getSalarySum(), is(80240L));
  }

  @Test
  public void testGetExpectedAverageAge() {
    AggregatedUserDetails aggregatedUserDetails = userDetailsFacade.aggregatedUserDetails();
    assertThat(Math.round(aggregatedUserDetails.getAgeAverage()), is(31L));
  }

  @Test
  public void testGetExpectedSummedChildren() {
    AggregatedUserDetails aggregatedUserDetails = userDetailsFacade.aggregatedUserDetails();
    assertThat(Math.round(aggregatedUserDetails.getChildrenSum()), is(1));
  }

  @Test
  public void testGetExpectedSummedSallaryOver1k() {
    AggregatedUserDetails aggregatedUserDetails = userDetailsFacade.aggregatedUserDetails(
        (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.ge(root.get("salary"), 1000));
    assertThat(aggregatedUserDetails.getSalarySum(), is(80000L));
  }
}