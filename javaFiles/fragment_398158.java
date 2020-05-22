public List<Organization> findOrganizationsByOrgAdminUser(String 
    CriteriaBuilder cb = entityManager.
    CriteriaQuery<Organization> query = cb.createQuery(Organization.
    Root<User> root = query.from(User.class);
    SetJoin<User, Organization> joinOrg = root.joinSet("organizations");
    SetJoin<User, GrantedRole> joinRoles = root.joinSet("roles");

    Predicate p1 = cb.equal(root.get("id"), userId);
    Predicate p2 = cb.equal(joinRoles.get("role"), Role.ROLE_MODM_ORGADMIN);
    Predicate p3 = cb.equal(joinOrg.get("id"), joinRoles.get("organization"));

    query.select(joinOrg);
    query.where(cb.and(p1, p2, p3));

    return entityManager.createQuery(query).getResultList();
}