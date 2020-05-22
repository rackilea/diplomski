@Mock
private CrudDAO<Profiles> dao;

@InjectMocks
private ProfileManagerImpl managerUnderTest;

@Mock
Profile profile = new Profile();

public Profile setProfile() {
    profile.setId(1);
    profile.setName("test");
    return profile;
}

@Test
public void testProfileCreate() throws Exception {
    setProfile();
    logger.info("Testing create for Manager");
    logger.info("Parameters: {}", profile);
    managerUnderTest.createEntry(profile);
    verify(dao).createEntry(ArgumentMatchers.eq(profile));  
    logger.info("Test passed");
}