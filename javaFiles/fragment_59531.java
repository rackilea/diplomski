MongoDbMessageSource mongoDbMessageSource = new MongoDbMessageSource(mongoDbFactory,
            new LiteralExpression(new BasicDBObject("status","new").toString().concat(".limit(1)")));
    mongoDbMessageSource.
            setCollectionNameExpression(new LiteralExpression("BankAccountDetail"));
    mongoDbMessageSource.setEntityClass(AccountBalanceDetailsWrapper.class);//added this for default
    return mongoDbMessageSource;