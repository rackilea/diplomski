@RunWith(MockitoJUnitRunner.class)
class TestCase {

  @Mock
  Syringe siringeMock;

  Patient patient;

  @Before
  public void setup() {
     patient = new Patient(siringeMock);
  }

}