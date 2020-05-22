public class AbstractClassTest {

 boolean methodCalled = false;

@Before
public void setUp() {
    methodCalled = false;
    AbstractClass myClass = new AbstractClass() {

        @Override
        public void myMethod(){
            methodCalled = true;
        }
    }
}

@Test
public void testMyImplementedMethod() {
    assertFalse(methodCalled);
    myClass.myImplementedMethod();
    assertTrue(methodCalled);
}
}