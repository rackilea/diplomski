@RunWith(Interceptors.class) 
    public class NameTest { 
            @Interceptor public TestName name = new TestName(); 

            @Test public void funnyName() { 
                    assertEquals("funnyName", name.getMethodName()); 
            } 
    }