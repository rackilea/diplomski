ps = con.prepareStatement(
        String.format("SELECT DoubleField, LongIntField FROM DemoTable WHERE ID=1")
        );
ResultSet rs = ps.executeQuery();
rs.next();
System.out.println(rs.getDouble(1));
System.out.println(rs.getInt(2));
System.out.println(9223372036854775807L);