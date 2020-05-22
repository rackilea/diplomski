public List<Company> getCompaniesByGroupIdManagedByAdmin(String groupId, Admin admin)
{
    final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    final CriteriaQuery<Company> query = cb.createQuery(Company.class);
    final Root<Admin> admins = query.from(Admin.class);

    final Join<Admin, Group> groups = admins.join(Admin_.groups);

    final Predicate[] predicates = new Predicate[2];

    predicates[0] = cb.equal(admins.get(Admin_.id), admin.getId());
    predicates[1] = cb.equal(groups.get(Group_.id), groupId);

    query.where(predicates)
    .select(groups.join(Group_.companies));

    return this.entityManager.createQuery(query).getResultList();
}