String queryString="SELECT e FROM Article e";
Query query = em.createQuery(queryString);
query.setHint("eclipselink.batch.type", "IN");
query.setHint("eclipselink.batch", "e.authors");
query.setFirstResult(position);
query.setMaxResults(amount);
List<Article> items=query.getResultList();