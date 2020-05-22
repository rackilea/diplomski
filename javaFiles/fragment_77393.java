public Criteria setMaxResults(int maxResults)
Set a limit upon the number of objects to be retrieved.
Parameters:
maxResults - the maximum number of results
Returns:
this (for method chaining)

Criteria criteria = session.createCriteria(Application.class)
                    .add(Restrictions.gt("lastModifiedOn", applicationLastRunTime))
                    .add(Restrictions.eq("lead", false))
                    .addOrder(Order.asc("lastModifiedOn"));
criteria.setMaxResults(40);
criteria.list()