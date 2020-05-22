class MyObj {

    final String foreName;
    final String surname;

    public MyObj(String foreName, String surname) {
        this.foreName = foreName;
        this.surname = surname;
    }

    public String getForeName() {
        return foreName;
    }

    public String getSurname() {
        return surname;
    }

}

enum Column {

    Forename {

                @Override
                String fromMyObj(MyObj it) {
                    return it.getForeName();
                }
            },
    Surname {

                @Override
                String fromMyObj(MyObj it) {
                    return it.getSurname();
                }
            },;

    abstract String fromMyObj(MyObj it);

    static String asSelectStatement(Set<Column> columns, String tableName) {
        return join(columns, ",", "SELECT ", " FROM " + tableName);
    }

    static String asCSVHeader(Set<Column> columns) {
        return join(columns, ",");
    }

    static String asCSV(Set<Column> columns, MyObj it) {
        return join(columns, (Column a) -> a.fromMyObj(it), ",");
    }

    private static String join(Set<Column> columns, String between) {
        return join(columns, new StringJoiner(between));
    }

    private static String join(Set<Column> columns, String between, String prefix, String suffix) {
        return join(columns, new StringJoiner(between, prefix, suffix));
    }

    private static String join(Set<Column> columns, StringJoiner joined) {
        return join(columns, (Column a) -> a.name(), joined);
    }

    private static String join(Set<Column> columns, Function<Column, String> as, String between) {
        return join(columns, as, new StringJoiner(between));
    }

    private static String join(Set<Column> columns, Function<Column, String> as, String between, String prefix, String suffix) {
        return join(columns, as, new StringJoiner(between, prefix, suffix));
    }

    private static String join(Set<Column> columns, Function<Column, String> as, StringJoiner joined) {
        for (Column c : columns) {
            joined.add(as.apply(c));
        }
        return joined.toString();
    }

    // Also simple to auto-populate prepared statements, build INSERT statements etc.
}

public void test() {
    Set<Column> columns = EnumSet.of(Column.Forename, Column.Surname);
    System.out.println("As Select: " + Column.asSelectStatement(columns, "MyTable"));
    System.out.println("As CSV Header: " + Column.asCSVHeader(columns));
    MyObj it = new MyObj("My Forename", "My Surname");
    System.out.println("As CSV: " + Column.asCSV(columns, it));
}