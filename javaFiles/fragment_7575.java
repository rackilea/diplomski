@RunWith(SpringRunner.class)
@DataJpaTest
public class IProfileDaoTest {

    @Autowired
    private IProfileDao profileDao; //This class extends JpaRepository<Profile, long>

    @Autowired
    private IMatchDao matchDao; //This class extends JpaRepository<Match, long>

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveProfileTest() throws Exception {

    @Test
    public void profileMatchRelationTest() throws Exception {
        //Test if matches stored by the IMatchDao are retrievable from the IProfileDao
        Profile profileOne = new Profile("Bob"),
            profileTwo = new Profile("Alex");

        //Persist the profiles so they exist when they are added to the match
        entityManager.persistAndFlush(profileOne);
        entityManager.persistAndFlush(profileTwo);

        //Create and persist the match with two profiles
        Match yourMatch = entityManager.persistFlushFind(new Match(profileOne, profileTwo));

        //Add the match to both profiles and persist them again.
        profileOne.matchOnes.add(yourMatch);
        entityManager.persistAndFlush(profileOne);
        profileTwo.matchTwos.add(yourMatch);
        entityManager.persistAndFlush(profileTwo);

        profileOne = profileDao.getOne(profileOne.getId());
        Assert.assertEquals("Match not retrievable by profile.", 1, profileOne.getMatchOnes().size());
    }
}