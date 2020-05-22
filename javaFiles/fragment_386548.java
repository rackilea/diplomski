@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class LicensePlateAuditableTests {
private Logger log = LogManager.getLogger();

@Autowired
private LicensePlateRepository licensePlateRepository;

@Autowired
private CountryRepository countryRepository;

private LicensePlate plate;
private final String PLATE_NUMBER_FIRST = "AA123BB";
private final String PLATE_NUMBER_SECOND = "AA956BB";
private int ENGINE_EURO_LEVEL_FIRST = 3;
private int ENGINE_EURO_LEVEL_SECOND = 3;

@Before
public void setup() {
    licensePlateRepository.deleteAll();
    countryRepository.deleteAll();

    Country country = new Country();
    country.setName("Italy");
    country.setIsoCode("IT");
    countryRepository.save(country);
}

@Test
public void checkThatVersionIsOneAfterCreateLicensePlate() {
    //given
    plate = createLicensePlateWithDefaultCountry(PLATE_NUMBER_FIRST, ENGINE_EURO_LEVEL_FIRST);
    //when
    plate = licensePlateRepository.save(plate);
    //then
    // First version number is  -- comment : if you want to comment something , include it into assert fail message
    assertEquals("version should be 1 for just created LicensePlate ", 1, plate.getVersion());
}

@Test
public void check_that_version_is_increased_when_changing_some_auditable_data() {
    //given
    plate = createLicensePlateWithDefaultCountry(PLATE_NUMBER_FIRST, ENGINE_EURO_LEVEL_FIRST);
    plate = licensePlateRepository.save(plate);
    //when
    setPlateEngineEuroLevelAndLicensePlate(PLATE_NUMBER_SECOND,ENGINE_EURO_LEVEL_SECOND);
    plate = licensePlateRepository.save(plate);
    //then
    assertEquals("version should be increased when Changing some auditable data",2, plate.getVersion());

    // Check if the entry in the database has updated data
    LicensePlate plateInDB = licensePlateRepository.findOne(plate.getId());
    assertNotNull(".. explanation..." , plateInDB);
    assertPlateNumberAndEngineEuroLevelAsInPlate(PLATE_NUMBER_SECOND , ENGINE_EURO_LEVEL_SECOND, plateInDB);
}

@Test
public void verify_revisions_after_two_changes() {
    //given
    plate = createLicensePlateWithDefaultCountry(PLATE_NUMBER_FIRST, ENGINE_EURO_LEVEL_FIRST);
    plate = licensePlateRepository.save(plate);
    //when
    setPlateEngineEuroLevelAndLicensePlate(PLATE_NUMBER_SECOND,ENGINE_EURO_LEVEL_SECOND);
    plate = licensePlateRepository.save(plate);
    //then
    Revisions<Integer, LicensePlate> revisions = licensePlateRepository.findRevisions(plate.getId());

    assertNotNull(".....something like : revisions should be found...." ,revisions);
    assertNotNull(".....something like : revisions.getContent should be found...." ,revisions.getContent());
    assertFalse(" should be present content for revisions " ,  revisions.getContent().isEmpty());
    assertEquals("I should have 2 revisions" ,2, revisions.getContent().size());

    //!!!! if you sure about order !!!!
    Revision<Integer, LicensePlate> revFirst = revisions.getContent().get(0);
    Revision<Integer, LicensePlate> revSecond = revisions.getContent().get(1);

    assertPlateNumberAndEngineEuroLevelAsInPlate(PLATE_NUMBER_FIRST, ENGINE_EURO_LEVEL_FIRST, revFirst.getEntity());
    assertPlateNumberAndEngineEuroLevelAsInPlate(PLATE_NUMBER_SECOND , ENGINE_EURO_LEVEL_SECOND, revSecond.getEntity());

}

private void assertPlateNumberAndEngineEuroLevelAsInPlate(String plateNumber , int engineEuroLevel , LicensePlate plate){
    assertEquals(engineEuroLevel, plate.getEngineEuroLevel());
    assertEquals(plateNumber , plate .getLicensePlate());
}

private LicensePlate createLicensePlateWithDefaultCountry(String plateNumber , int engineEuroLevel){
    LicensePlate plate = new LicensePlate();
    setPlateEngineEuroLevelAndLicensePlate(plateNumber , engineEuroLevel);
    plate.setCoutry(countryRepository.findFirstByOrderByIdAsc());
    return plate;
}

private void setPlateEngineEuroLevelAndLicensePlate(String plateNumber , int engineEuroLevel){
    plate.setEngineEuroLevel(engineEuroLevel);
    plate.setLicensePlate(plateNumber);
}
}