String template = "DELETE FROM %s WHERE start < :calculatedStop";
String jpql = String.format(template , MyClass.class.getCanonicalName());

long calculatedStop = new java.util.Date().getTime() - INTERVAL;// INTERVAL is a constant

Query q = em.createQuery(jpql);
q.setParameter("calculatedStop", calculatedStop);
q.executeUpdate();