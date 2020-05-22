class InnerClass {
    public void doSomething(String fileName) {
    }
}

class SomeClass {

    InnerClass innerClass;

    public boolean doSomething(String fileName) {
        innerClass.doSomething(fileName);
        return true;
    }
}

@ExtendWith(MockitoExtension.class)
class SomeClassTest {

    @InjectMocks
    SomeClass someClass;

    @Mock
    InnerClass innerClass;

    @Test
    public void test() {
        someClass.doSomething("test");
        Mockito.verify(innerClass, Mockito.times(1)).doSomething(Mockito.any());
    }
}