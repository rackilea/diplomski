final Object[][] table = new String[4][];
table[0] = new String[] { "foo", "bar", "baz" };
table[1] = new String[] { "bar2", "foo2", "baz2" };
table[2] = new String[] { "baz3", "bar3", "foo3" };
table[3] = new String[] { "foo4", "bar4", "baz4" };

for (final Object[] row : table) {
    System.out.format("%15s%15s%15s\n", row);
}