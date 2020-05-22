@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationTest {

    @Autowired RelationABEntityRepository relationABEntityRepository;
    @Autowired ARepository aRepository;
    @Autowired BRepository bRepository;


    @Test
    public void test(){
        EntityA a = new EntityA();
        a = aRepository.save(a);
        EntityB b = new EntityB();
        b = bRepository.save(b);

        //Entities A and B in the DB at this point

        RelationABId relationABID = new RelationABId(a.getId(), b.getId());

        final boolean relationshipExist = relationABEntityRepository.existsById(relationABID);
        assertFalse(relationshipExist);

        if(! relationshipExist){
            RelationABEntity relation = new RelationABEntity(a.getId(), b.getId());
            relationABEntityRepository.save(relation);
        }

        final boolean relationshipExitNow = relationABEntityRepository.existsById(relationABID);
        assertTrue(relationshipExitNow);
        /**
         * As you can see, modifying your model you can create relationships without loading big list and without complex queries. 
         */
    }    
}