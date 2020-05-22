@RunWith(MockitoJUnitRunner.class)
public class SomeClassTest {

    private SomeClass classUnderTest;

    @Mock
    private MappingDef mappingDef;

    @Before init() {
        classUnderTest = new SomeClass(mappingDef);
        // defaultMockBehaviour: 
when(mappingDef.userToUserDto(anyObject(User.class).thenReturn(new UserDto());
    } 

    @test
    public void someTest(){
         UserDto userDto = someClass.myMethodToTest();

         //and here some asserts
    }