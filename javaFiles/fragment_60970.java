CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<SublogTypeMapV> query = builder.createQuery(SublogTypeMapV.class);
Root<SublogTypeMapV> root = query.from(SublogTypeMapV.class);
query = query.select(root);
if("some boolean expression") {
    query = query.where(builder.equal(root.get("responsibleGroupId"), responsibleGroupId));
}