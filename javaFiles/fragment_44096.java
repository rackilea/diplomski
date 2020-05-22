public static void main(String[] args) {
    String statementString = new String("CREATE USER \"Company\" IDENTIFIED BY \"null\";CREATE TABLE Table0 ();CREATE TABLE Table1 ();CREATE TABLE Table2 ();");
    String[] statementArray = statementString.split(";");
    for (String statement : statementArray) {
        System.out.println(statement);
    }
}