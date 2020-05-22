@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestClass {


    @IfProfileValue(name = "os.name", values = {"Linux"})
    @Test
    public void testMe() {
     // will run only in linux, otherwise
     // won't even try to load an 
     // application context
    ....
    }
  }