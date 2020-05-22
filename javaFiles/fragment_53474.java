public List<Collection> occasions() {
    QueryParams queryParams = new QueryParams();
    final StringBuilder sb = new StringBuilder();
    sb.append("published = true ");
    sb.append("AND collection_type = '");
    sb.append(CollectionType.OCCASION.getName());
    sb.append("'");
    queryParams.setWhere(sb.toString());

    return list(queryParams);
}