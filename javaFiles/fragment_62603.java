@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootJPAIntegrationTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void givenTestEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        TestEntity TestEntity= testEntityRepository
          .save(new TestEntity ("test"));
        TestEntity  foundEntity = genericEntityRepository
          .findOne(genericEntity.getId());

        assertNotNull(testEntity);
        assertEquals(testEntity.getValue(), foundEntity.getValue());
    }
}