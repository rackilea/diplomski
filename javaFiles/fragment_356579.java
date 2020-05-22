@RunWith(SpringRunner.class)
@DataJpaTest
pubic class EntityTest {
    @Autowired TestEntityManager entityManager;

    @Test
    public void saveShouldPersistData() throws Exception {
        User saved = entityManager.persistFlushFind(new User("username", "password"));
        assertNonNull(saved);
    }
}