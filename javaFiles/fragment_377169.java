public static void main(String[] args) throws SQLException {
        String databaseUrl = "jdbc:mysql://localhost:3306/YOUR_DATABASE";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "root");
        // instantiate the dao
        Dao<MyTripTable, Long> tripDao = DaoManager.createDao(connectionSource, MyTripTable.class);
        Dao<PortTable, Long> portDao = DaoManager.createDao(connectionSource, PortTable.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTable(connectionSource, MyTripTable.class);
        TableUtils.createTable(connectionSource, PortTable.class);

        long time1 = Calendar.getInstance().getTimeInMillis();

        // crate data
        MyTripTable myFirstTrip = new MyTripTable();
        myFirstTrip.setTimestamp(time1);

        tripDao.create(myFirstTrip);

        PortTable port1 = new PortTable();
        port1.setTimestamp(time1);
        port1.setTripAssigned(myFirstTrip);

        PortTable port2 = new PortTable();
        port2.setTimestamp(time1);
        port2.setTripAssigned(myFirstTrip);

        PortTable port3 = new PortTable();
        port3.setTimestamp(time1);
        port3.setTripAssigned(myFirstTrip);

        portDao.create(port1);
        portDao.create(port2);
        portDao.create(port3);

        List<MyTripTable> alltrips = tripDao.queryForAll();
        for (MyTripTable trip : alltrips) {
            System.out.println(trip);
        }

        List<PortTable> allPorts = portDao.queryForAll();
        for (PortTable port : allPorts) {
            System.out.println(port);
        }

        MyTripTable mOneTrip = tripDao.queryForId(myFirstTrip.getId());
        ForeignCollection<PortTable> mPortsForOneTrip = mOneTrip.getPorts();
        System.out.println(mPortsForOneTrip);

    }