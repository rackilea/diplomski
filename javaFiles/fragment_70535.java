@Override
public String generateJumpToItemQuery(int itemIndex, int pageSize) {
    int page = itemIndex / pageSize;
    int offset = (page * pageSize) - 1;
    offset = offset<0 ? 0 : offset;
    String limitClause = new StringBuilder().append("LIMIT 1 OFFSET ").append(offset).toString();
    return SqlPagingQueryUtils.generateLimitJumpToQuery(this, limitClause);
}