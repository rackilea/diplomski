String sql = "insert all"
            + " into t_stock_purchase values(?,?,?,?)"
            + " into t_stocks values(?,?,?)"
            + " into t_stock_status(godownname,itemname,receivedfrom,"
            + "receiveddate,receivedqty,availablebal) values(?,?,?,?,?,?)"
            + " select 1 from dual";