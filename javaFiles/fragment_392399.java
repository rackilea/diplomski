@RunWith(MockitoJUnitRunner.class)
public class MappingDefTest {

  MappingDef classUnderTest;

  @Before
  void before() {
       // use some reflection to get an implementation
      Class aClass = Class.forName( MappingDefImpl.class.getCanonicalName() );
      Constructor constructor =
        aClass.getConstructor(new Class[]{MappingUtils.class});
      classUnderTest = (MappingDef)constructor.newInstance( Mappers.getMapper( MappingUtils.class ));
  }

  @Test
  void test() {
     // test all your mappings (null's in source, etc).. 
  }