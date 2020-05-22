SQLLogin {
    org.apache.openejb.core.security.jaas.SQLLoginModule required
    jdbcURL="jdbc:hsqldb:mem:sqltest"
    userSelect="SELECT username, password FROM users WHERE username = ?"
    groupSelect="SELECT username, grp FROM groups WHERE username = ?";
};