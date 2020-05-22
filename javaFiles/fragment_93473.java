Criteria criteria = session.createCriteria(Issue.class);
 criteria.setFirstResult(from);
 criteria.setMaxResults(size);
 criteria.setFetchMode("Issue.issueTracker",FetchMode.JOIN);
 criteria.add(Restrictions.eq("status", "Escalate To"));
 Criteria subCriteria = criteria.createCriteria("issueTracker");
 subCriteria.addOrder(Order.desc("tracked_time"));
 return criteria.list();