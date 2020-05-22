EbeanServer server = Ebean.getServer(null);

    Transaction transaction = server.beginTransaction();
    try {
        // Use JDBC batch API with a batch size of 100
        transaction.setBatchSize(100);
        // Don't bother getting generated keys
        transaction.setBatchGetGeneratedKeys(false);
        // Skip cascading persist 
        transaction.setPersistCascade(false);

        // persist your beans ...
        Iterator<YourEntity> it = null; // obviously should not be null 
        while (it.hasNext()) {
            YourEntity yourEntity = it.next();
            server.save(yourEntity);
        }

        transaction.commit();
    } finally {
        transaction.end();
    }