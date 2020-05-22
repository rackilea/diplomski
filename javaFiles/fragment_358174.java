@RunWith(SpringJUnit4ClassRunner.class)
public class DAOTest extends AbstractContainer {

@Test
public void testDAO() {

EntityManager em = factory.createEntityManager();
em.getTransaction().begin();
}
}