public class SequenceGenerator
{
    private static final String CHAR_LIST =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 5;
    private static final Random RANDOM = new Random();

    /**
     * Generates and returns a random string
     */
    public String generateRandomString() {
        char[] chars = new char[RANDOM_STRING_LENGTH];
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = RANDOM.nextInt(CHAR_LIST.length());
            chars[i] = CHAR_LIST.charAt(number);
        }
        return new String(chars);
    }

    public static DataSource getMySQLDataSource() throws Exception {
        Properties props = new Properties();
        MysqlDataSource mysqlDS = null;

        FileInputStream fis = new FileInputStream(
                "D:/Assignments/Sequence/db.properties");
        try {
            props.load(fis);
        } finally {
            fis.close();
        }
        mysqlDS = new MysqlDataSource();
        mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
        mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
        mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        return mysqlDS;
    }

    public static void main(String[] args) throws Exception {
        SequenceGenerator sg = new SequenceGenerator();
        Connection con = getMySQLDataSource().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("insert into nodes_test values (?,?)");
            for (int i = 0; i < 50000; i++) {
                pst.setInt(1, i);
                pst.setString(2, sg.generateRandomString());
                pst.executeUpdate();
                System.out.println(i);
            }
            pst.close();
        } finally {
            con.close();
        }
    }
}