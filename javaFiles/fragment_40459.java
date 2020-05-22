StringBuilder sb = new StringBuilder(/*...number big enough for the whole thing...*/);
sb.append("SELECT [Foo], [Bar] FROM ");
sb.append(tableName); // **NOT** from a user, from internal logic
sb.append(" WHERE [X] = ?");
try (PreparedStatement ps = connection.prepareStatement(sb.toString())) {
    ps.setString(1, /*...*/); // This can be user-derived
    // ...
}