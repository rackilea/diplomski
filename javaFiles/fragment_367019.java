if (persistence){
        //  Configuring Cassandra's persistence
        DataSource dataSource = new DataSource();
        // ...here go the rest of your settings as they appear now...
        configuration.setWriteBehindEnabled(true);

        configuration.setStoreKeepBinary(true);
    }