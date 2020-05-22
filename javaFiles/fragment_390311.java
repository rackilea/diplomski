public class LoginVerifier {

    public Optional<User> login(String username, String password) throws SQLException {
        ConectaredB ConectaredB = new ConectaredB();
        Connection conectare = ConectaredB.logareDB();

        PreparedStatement PSMG = null;
        ResultSet RSMG = null;
        String Interogare = "SELECT * FROM accounts where Username = ? and Password = ?";

        PSMG = conectare.prepareStatement(Interogare);
        PSMG.setString(1, username);
        PSMG.setString(2, password);

        RSMG = PSMG.executeQuery();
        if(RSMG.next()) {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setId(RSMG.getInt("id"));
            user.setAdmin(RSMG.getInt("Admin") == 1);

            return Optional.of(user);
        }

        return Optional.empty();
    }
}