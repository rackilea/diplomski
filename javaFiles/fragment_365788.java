public class UserAdminTest {
    static class DBConnection { boolean isAdmin(String userName) { return false; } }

    static class UserAdmin {
        boolean removeUser(String userName) {
            DBConnection dbConnection = new DBConnection();

            if (!dbConnection.isAdmin(userName)) {
                // remove user
                return true;
            }

            return false;
        }
    }

    @Tested UserAdmin userAdmin;
    @Mocked DBConnection dBConnection;

    @Test
    public void doesNotRemoveUserWhenAdmin() throws Exception {
        new Expectations() {{ dBConnection.isAdmin("admin"); result = true; }};

        boolean removedIt = userAdmin.removeUser("admin");

        assertFalse(removedIt);
    }
}