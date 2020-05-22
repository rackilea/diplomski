BooleanJunction<?> boolForOrgIds = queryBuilder.bool();
for (Integer orgId: orgIds) {
   boolForOrgIds.should(queryBuilder.keyword().onField("orgId").matching(orgId).createQuery());
}


BooleanJunction<?> boolForWholeQuery = queryBuilder.bool();
boolForWholeQuery.must(boolForOrgIds.createQuery());
boolForWholeQuery.must(queryBuilder.keyword().onField("name").matching("anyName").createQuery());
// and add as many "must" as you need
LuceneQuery query = boolForWholeQuery.createQuery();