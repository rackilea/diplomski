@ActiveProfiles(Profiles.TEST)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { FullIntegrationTestConfiguration.class, BaseTestConfiguration.class, MemberCachingIntegrationTest.Config.class })
public class MemberCachingIntegrationTest {

    @Autowired
    private MemberRepository cachedRepository;

    @Autowired
    private MockProvider mockProvider;

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void test() {
        when(mockProvider.get().findByEmail(anyString())).thenReturn("foo", "bar");

        String firstInvocation = cachedRepository.findByEmail("foo@foo.com");
        assertThat(firstInvocation, is("foo"));

        String secondInvocation = cachedRepository.findByEmail("foo@foo.com");
        assertThat(secondInvocation, is("foo"));

        verify(mockProvider.get(), times(1)).findByEmail("foo@foo.com");

        String thirdInvocation = cachedRepository.findByEmail("bar@bar.com");
        assertThat(thirdInvocation, is("bar"));

        verify(mockProvider.get(), times(1)).findByEmail("bar@bar.com");
    }

    @Configuration
    static class Config {

        private MemberRepository mockRepository = mock(MemberRepository.class);

        @Bean
        public MemberRepository cachedRepository() {
            return mockRepository;
        }

        @Bean
        public MockProvider mockProvider() {
            return new MockProvider(mockRepository);
        }

    }

    public static class MockProvider {

        private final MemberRepository repository;

        public MockProvider(MemberRepository repository) {
            this.repository = repository;
        }

        public MemberRepository get() {
            return this.repository;
        }

    }
}