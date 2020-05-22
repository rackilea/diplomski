String sql = "SELECT id FROM gom_conversation c INNER JOIN gom_user_gom_conversation u " +
            "ON c.id = u.gom_conversation_id " +
            "WHERE " +
            "u.gom_user_id IN (:user, :recipient) HAVING COUNT(DISTINCT u.gom_user_id) = 2;";


RawSql rawSql = RawSqlBuilder.parse(sql)
            .tableAliasMapping("id", "id")
            .create();

ConversationModel conversation = find.setRawSql(rawSql)
            .setRawSql(rawSql)
            .setParameter("user", user.id)
            .setParameter("recipient", recipient.id)
            .findUnique();

return conversation;