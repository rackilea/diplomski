// HQL Query to retrieve the list of FormResult IDs
StringBuilder hql = new StringBuilder();
hql.append("SELECT r.id");
hql.append(" FROM QuestionAnswer qa RIGHT JOIN qa.formResult as r");
hql.append(" WHERE r.formId = :formId AND (qa.status = :status OR qa.status IS NULL)");
hql.append(" GROUP BY r.id");
hql.append(" ORDER BY COUNT(DISTINCT qa.id) DESC"));

Query query = HibernateUtil.getSession().createQuery(hql.toString());
query.setParameter("formId", formId);
query.setParameter("status", QuestionAnswerStatus.CORRECT);

// Retrieve the list of FormResult objects from the list of IDs previously retrieved
List<Long> result = query.list();
if (result != null && !result.isEmpty()) {
  for (Long resultId : result) {
    formResults.add(getData(FormResult.class, resultId));
  }
}