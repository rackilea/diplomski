//Query returning the set of devices in a given market
    String stm ="SELECT device "
                "FROM mopdb.devices d " +
                "INNER JOIN mopdb.markets m " +
                "ON (d.market_id = m.market_id) " +
                "WHERE (m.short = ?) " +
                "ORDER BY d.device_id ";