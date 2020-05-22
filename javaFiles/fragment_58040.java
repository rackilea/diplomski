public class Bcrypter {

    public static void main(String args []) {

        int lower = Integer.parseInt(args[0]);
        int upper = Integer.parseInt(args[1]);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int row = 0;
        try {
            conn = Database.getConnection();
            pstmt = conn.prepareStatement("SELECT id, user_pass, user_pass_bcrypt FROM users ORDER BY id LIMIT ?, ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, lower);
            pstmt.setInt(2, upper);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                String user_pass = rs.getString("user_pass");
                String user_pass_encrypted = Encryption.encrypt(user_pass);

                if (Encryption.isMatch(user_pass, user_pass_encrypted)) {
                    rs.updateString("user_pass_bcrypt", user_pass_encrypted);
                    rs.updateRow();

                    if (++row % 10000 == 0) {
                        System.out.println(row);
                    }

                } else {
                    System.out.println("Mismatch " + user_pass);
                }
            }
            System.out.print("DONE");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e);
        } finally {
            Database.closeConnection(conn, pstmt, rs);
        }
    }
}


public final class Encryption {

    private Encryption() {
        // can't instantiate
    }

    /**
     * Encrypts a password. The gensalt() method's default param is
     * 10 but it's lowered here, assuming better performance.
     */
    public static String encrypt (String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(5));
    }

    /**
     * Checks whether a plaintext password matches one that has been
     * hashed previously
     */
    public static Boolean isMatch(String plainPassword, String hashedPassword) {
        return (BCrypt.checkpw(plainPassword, hashedPassword));
    }
}