public List<TestPOJOcategory> getAllCategory(final String keyword, final int nFirst,
    final int nPageSize,
    final String sortColumnId,
    final boolean bSortOrder) {

  DetachedCriteria crit = DetachedCriteria.forClass(TestPOJOcategory.class);
  crit.add(Restrictions.ilike("categoryname", keyword))
   .addOrder(bSortOrder ? Order.asc(sortColumnId) : Order.desc(sortColumnId));
  getHibernateTemplate().setCacheQueries(true); // works on both queries and criteria
  return (List<TestPOJOcategory>) getHibernateTemplate()
   .findByCriteria(crit, nFirst, nPageSize);
}