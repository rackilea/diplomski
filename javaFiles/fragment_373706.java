@Mock
Foo fooMock;
MyClass myClass;

@BeforeEach
void init(){
    myClass = new MyClass(fooMock);
}

@Test
public void method1(){
   Mockito.when(fooMock.method3()).thenReturn("dummy value");
   // call method1() 
   // do assertions
}