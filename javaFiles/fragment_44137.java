public static <T extends ItemWithIdTag> T fOwner(Class<T> type, String catName) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
    Root<T> fromType = criteriaQuery.from(type);
    Root<RfIdTag> fromRfId = criteriaQuery.from(RfIdTag.class);

    Path<Object> pathCode = fromRfId.get("code");
    Path<Object> pathIdTagType = fromType.get("idTag");
    Path<Object> pathIdTagRfId = fromRfId.get("id");

    CriteriaQuery<T> select = criteriaQuery.select(fromType);
    select.where(
            criteriaBuilder.equal(pathCode, catName),
            criteriaBuilder.equal(pathIdTagType, pathIdTagRfId));

    TypedQuery<T> q = em.createQuery(select);
    return q.getSingleResult();
}