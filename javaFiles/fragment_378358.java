c = DriverManager.getConnection("jdbc:sqlite:" + naziv + ".db");

    stmt = c.createStatement();

    ResultSet rs = stmt.executeQuery("SELECT * FROM PRISTUPI;");

    while(rs.next())
    {
        if(Decrypt(rs.getString("korisnickoime")).equals(korisnickoime) &&
            Decrypt(rs.getString("vage")).equals(serijskibroj))
            return true;
    }

    rs.close();
    stmt.close();
    c.close();