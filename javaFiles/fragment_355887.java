public class ClientRegistrationManager {
  static class MemberQueriesFactory {
    MemberQueries getMemberQueries() {
      return ObjectFactory.newMemberQueries(crudService);
    }
  }

  /** Package-private. Visible for unit testing. */
  MemberQueriesFactory memberQueriesFactory = new MembersQueryFactory();
}

@RunWith(MockitoJUnitRunner.class)
public class ClientRegistrationManagerTest {
  @Mock ClientRegistrationManager.MembersQueryFactory mockMembersQueryFactory;

  private ClientRegistrationManager getManagerForTest() {
    ClientRegistrationManager manager = new ClientRegistrationManager();
    manager.memberQueriesFactory = mockMembersQueryFactory;
    return manager;
  }
}