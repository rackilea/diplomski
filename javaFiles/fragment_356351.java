StringJoiner sj = new StringJoiner(" OR ");
    String sql = "SELECT B.DATE AS DT, B.EMP_ID, E.FNAME, E.LNAME, MONEY_SENT, RENT, PHONE, GAS, ELECTRICITY, INTERNET, OTHER"
                    + " FROM EMPLOYEE E INNER JOIN BILLS B ON E.EMP_ID = B.EMP_ID"
                    + " WHERE ";
    List values = new ArrayList();
    // EmpCode MUST be a Integer, so it can be null
    if (EmpCode != null) {
        sj.add("B.EMP_ID = ?");
        values.add(EmpCode);
    }
    if (FName != null) {
        sj.add("E.FNAME = ?");
        values.add(FName);
    }
    if (LName != null) {
        sj.add("E.LNAME = ?");
        values.add(LName);
    }
    if (sDate != null && eDate != null) {
        sj.add("DATE BETWEEN ? AND ?");
        values.add(sDate);
        values.add(eDate);
    }

    sql += sj.toString();

    Connection connect = null;
    try (PreparedStatement ps = connect.prepareStatement(sql)) {

        for (int index = 0; index < values.size(); index++) {
            ps.setObject(index + 1, values.get(index));
        }

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                //...
            }

        }

    } catch (SQLException exp) {
        exp.printStackTrace();
    }