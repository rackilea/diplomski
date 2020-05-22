Connection conn = ... // the connection is open
...
for (String someID : someIDs) {
    SomeClass sc = null;
    PreparedStatement
        stmt = conn.prepareStatement ("SELECT A, B, C, D, E, F, G, H FROM T WHERE A = ?");
    stmt.setString (1, "someID");
    ResultSet res = stmt.executeQuery ();
    if (res.next ()) {
        sc = new SomeClass ();
        sc.setA (res.getString (1));
        sc.setB (res.getString (2));
        sc.setC (res.getString (3));
        sc.setD (res.getString (4));
        sc.setE (res.getString (5));
        sc.setF (res.getInt (6));
        sc.setG (res.getString (7));
        sc.setH (res.getByte (8)); // the exception is thrown here
    }
    stmt.close ();
    conn.commit ();
    if (sc != null) {
        // do some processing that involves loading other records from the
        // DB using the same connection
    }
}
conn.close();