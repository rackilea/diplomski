@RunWith(MockitoJUnitRunner.class)
public class FavouriteProfilesControllerTest extends WithApplication {

   @InjectMocks
   private FavouriteProfilesController controller;

   @Mock
   private UserProvider userProvider;

   @Mock
   private MessagesApi msg;

   @Test
   public void test() {
     Assert.assertNotNull(userProvider);
     Assert.asserNotNull(msg);
   }
}