@RunWith(SpringRunner.class)
@SpringBootTest
@ProfileValueSourceConfiguration(VPNConnectivityProfileValueSource.class)
@IfProfileValue(name = "vpn.enabled", value = "true")
public class MyTestClass {

   @Test
   public void testMe() {
     ....
   }
}