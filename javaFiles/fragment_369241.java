public class MyClass {

    private ClassUnknown cu;

    public MyClass(ClassUnknown cu) {
        this.cu = cu;
    }

    public void mainMethod(String s) {
        try {
            String methodUnknown = cu.methodUnknown(s);
            System.out.println(methodUnknown);
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

...

@Before
public void setUp() {
    cu = mock(ClassUnknown.class);
    // The next two lines seems to be wrong
    when(cu.methodUnknown("hello")).thenReturn("hello there");
    when(cu.methodUnknown("???")).thenThrow(new Exception("don't know"));   

    mc = new MyClass(cu); // Now, the MyClass instance will use the mock.        
}