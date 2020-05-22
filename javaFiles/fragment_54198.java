@RunWith(MockitoJUnitRunner.class)
public class TestExamples(){

    @Mock
    ExampleTwo exampleTwo;

    @InjectMocks
    ExampleOne exampleOne

    @Test
    void test(){

        exampleOne.doSomethingOne();

        verify(exampleTwo).doSomethingTwo();
    }    
}