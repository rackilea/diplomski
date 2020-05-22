try(Connection con = getConnection();
                PreparedStatement stmt = createPreparedStatement(con, state);

                ResultSet rs = stmt.executeQuery();
        )
        {
        while (rs.next()) {
            customers.add(new Customer(rs.getInt("CustomerID"),
                    rs.getString("Name"),
                    rs.getString("City"),
                    rs.getString("StateProvince")));
        }
    }catch (SQLException e) {
        e.printStackTrace();
    }