Date from = new java.util.Date() {
  public String toString() {
    return DatatypeConverter.printDateTime(Calendar.getInstance());
  }
};

PojoQueryDefinition query =
    queryBuilder.filteredQuery(
            queryBuilder.range("createdDate", Operator.GT, from)
    );

PojoPage<CaseComment> results = pojoRepository.search(query,1);