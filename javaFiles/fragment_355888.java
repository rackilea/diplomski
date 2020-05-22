@RunWith(MockitoJUnitRunner.class)
public class ClientRegistrationManagerTest {
  @Mock MemberQueries memberQueries;

  private ClientRegistrationManager getManagerForTest() {
    ClientRegistrationManager manager = new ClientRegistrationManager() {
      @Override void getMemberQueries() {
        return memberQueries;
      }
    };
  }
}