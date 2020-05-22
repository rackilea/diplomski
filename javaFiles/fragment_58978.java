final CriteriaBuilder critBuilder = entityManager.getCriteriaBuilder();
final CriteriaQuery<CarTaskByOperator> critQuery = critBuilder.createQuery(CarTaskByOperator.class);
final Root<CarTaskOperationHist> root = critQuery.from(CarTaskOperationHist.class);

// Select and Group Expressions
final Expression<Long> exOperatorId = root.get("operatorId");
final Expression<String> exOperatorName = root.get("operatorBean").get("name");
final Expression<String> exMoment = critBuilder.function("TRUNC", String.class, root.get("moment"));
final Expression<String> exType = root.get("carTaskBean").get("carIncidenceBean").get("carIncidenceTypeBean").get("description");
final Expression<Long> exAmount = critBuilder.count(root.get("incidenceId"));

final CriteriaQuery<CarTaskByOperator> select = critQuery.multiselect(exOperatorId, exOperatorName, exMoment, exType, exAmount);
select.groupBy(exOperatorId, exOperatorName, exMoment, exType);

TypedQuery<CarTaskByOperator> query = entityManager.createQuery(select);
List<CarTaskByOperator> resultList = query.getResultList();