String query = "INSERT INTO FORUMS (FORUM_ID, FORUM_NAME, FORUM_DESC)
 VALUES (:forumId,:forumName,:forumDesc)";
    Map namedParameters = new HashMap();
    namedParameters.put("forumId", Integer.valueOf(forum.getForumId()));
    namedParameters.put("forumName", forum.getForumName());
    namedParameters.put("forumDesc", forum.getForumDesc());
    namedParameterJdbcTemplate.update(query, namedParameters);