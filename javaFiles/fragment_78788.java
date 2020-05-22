ProgrammaticLogin pl = new ProgrammaticLogin();
String realmName = "secureJDBCRealm";
try {
    pl.login("bob", "bob".toCharArray(), realmName, true);
} catch (Exception e){
    e.printStackTrace();
} finally {
    pl.logout();
}