String statusRequest = "UPDATE home "
         + "SET date_ma = ?, nr_days_ma = ? "
         + "WHERE nr_req = ?";
SQLQuery simpleSQL = session.createSQLQuery(statusRequest );
simpleSQL.setParameter(1, some_value);
simpleSQL.setParameter(2, some_value);
simpleSQL.setParameter(3, some_value);