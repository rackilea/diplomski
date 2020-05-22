List<Integer> orgIds = Arrays.asList(1, 3, 8);

BooleanJunction<?> bool = queryBuilder.bool();
for (Integer orgId: orgIds) {
   bool.should( queryBuilder.keyword().onField("orgId").matching(orgId).createQuery() );
}
LuceneQuery query = bool.createQuery();