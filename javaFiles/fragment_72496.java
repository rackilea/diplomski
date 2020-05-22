public List<Profil> findProfilsByRoleId(Long roleId) {
    final CriteriaBuilder builder = getCriteriaBuilder();
    final CriteriaQuery<Profil> query = builder.createQuery(Profil.class);
    final Root<RoleProfil> from = query.from(RoleProfil.class);

    query.select(from.get(RoleProfil_.profilId));
    query.where(builder.equal(from.get(RoleProfil_.roleId).get(Role_.roleId), roleId));

    final TypedQuery<Profil> typedQuery = getEntityManager().createQuery(query);
    return typedQuery.getResultList();

}