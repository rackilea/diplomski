CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<Brand> cQuery = builder.createQuery(Brand.class);
Root<Brand> from = cQuery.from(Brand.class);
CriteriaQuery<Brand> select = cQuery.select(from);
.
.
//Created many predicates and added to **Predicate[] pArray**
.
.
CriteriaQuery<Long> cq = builder.createQuery(Long.class);
cq.select(builder.count(cq.from(Brand.class)));
// Following line if commented causes [org.hibernate.hql.ast.QuerySyntaxException: Invalid path: 'generatedAlias1.enabled' [select count(generatedAlias0) from xxx.yyy.zzz.Brand as generatedAlias0 where ( generatedAlias1.enabled=:param0 ) and ( lower(generatedAlias1.description) like :param1 )]]
em.createQuery(cq);
cq.where(pArray);
Long count = em.createQuery(cq).getSingleResult();
.
.
select.where(pArray);
.
.
// Added orderBy clause
TypedQuery typedQuery = em.createQuery(select);
typedQuery.setFirstResult(startIndex);
typedQuery.setMaxResults(pageSize);
List resultList = typedQuery.getResultList()