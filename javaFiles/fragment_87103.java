@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional
public class OrganizationRepositoryTests {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PersistenceContext
    private Entitymanager em;

    @Test
    public void testDeleteOrganization() {
        Organization organization = 
                organizationRepository.findByName(organizationName).get(); 

        Department d1 = new Department();
        d1.setName("d1");
        d1.setOrganization(organization);

        Department d2 = new Department();
        d2.setName("d2");
        d2.setOrganization(organization);

        departmentRepository.save(d1);
        departmentRepository.save(d2);

        // this fails because there is no trip to the database as Organization 
        // (the one loaded in the first line)
        // already exists in the current entityManager - and you have not 
        // updated its list of departments.
        // uncommenting the following line will trigger a reload and prove 
        // this to be the case: however it is not a fix for the issue.

        // em.clear();

         assertEquals(2,
             organizationRepository.getOne(
               organization.getId()).getDepartments().size()); 

        //similary this will execute without error with the em.clear() 
        //statement uncommented
        //however without that Hibernate knows nothing about the cascacding 
        //delete as there are no departments
        //associated with organisation as you have not added them to the list.
        organizationRepository.deleteById(organization.getId());

        assertFalse(organizationRepository.findByName(organizationName).isPresent());
        assertEquals(0, departmentRepository.findAll().size()); 
    }
}