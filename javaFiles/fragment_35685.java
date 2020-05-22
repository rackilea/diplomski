ResultSet d = DBUtilities.getDevicesFromMarket(m.toString());
    while(d.next()) {
        String loopback, oob;
        Device deviceName = new Device(d.getString("device"), 
                (DBInet.valueOf(d.getString("loopback"))),
                (DBInet.valueOf(oob = d.getString("oob"))), 
                d.getString("traffic_type"), d.getString("clli"),
                d.getString("rack"), d.getInt("market_id"),
                d.getString("codebase"));
        model.addElement(deviceName);
    }