private final String SELECT_STAR_FROM = "select * from ";
private final String USERS_TABLE = "users";

// many lines of code
PreparedStatement stmt0 = conn.prepareStatement(SELECT_STAR_FROM + USERS_TABLE);

// this line would fail at run time
PreparedStatement stmt1 = conn.prepareStatement("selct * from users");

// this line fails at compile time and the compiler points you at it
PreparedStatement stmt0 = conn.prepareStatement(SELCT_STAR_FROM + USERS_TABLE);