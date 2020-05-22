QueryBuilder<Story, Integer> queryBuilder = StoryDao.queryBuilder();
SelectArg titleArg = new SelectArg();
queryBuilder.where().eq(Story.TITLE_FIELD_NAME, titleArg);
PreparedQuery<Story> preparedQuery = queryBuilder.prepare();
titleArg.setValue(title);
List<Story> accountList = StoryDao.query(preparedQuery);