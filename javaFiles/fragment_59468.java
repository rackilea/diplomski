if (parentId != null) {
    Query parentIdQuery = new TermQuery(new Term("parentID", parentId.toString()));
    booleanQuery.add(parentIdQuery, BooleanClause.Occur.MUST);
} else {
    Query parentIdQuery = new ConstantScoreQuery(new FieldValueFilter("parentID", true));
    booleanQuery.add(parentIdQuery, BooleanClause.Occur.MUST);