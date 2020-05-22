QueryBuilder<Message, Integer> messagesQueryBuilder = dbManager.getMessagesDao().queryBuilder();   
Where<Message, Integer> resultedQuery = messagesQueryBuilder.where().in(Message.SCHOOL_COLUMN_NAME, schoolIntegerQueryBuilder);

messagesQueryBuilder.orderBy(Message.MESSAGE_TIMESTAMP, false);
Message message = messagesQueryBuilder.queryForFirst();

Long count = messagesQueryBuilder.countOf();