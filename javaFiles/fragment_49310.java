conn.setAutoCommit(false);// start transaction
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); 
        String sql2="update EmailQueue set process_flg='Y' where id="+id;
        //getting deadlocks here
        stmt=conn.createStatement();
        stmt.executeUpdate(sql2);
        conn.commit();// complete transaction
        conn.setAutoCommit(true);