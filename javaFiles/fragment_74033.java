HashSet<Permission> set = new HashSet<Permission>();
for (CenterProfile cp : usuario.getCentersProfileUsuario()) {
    // First we build subcriteria to return all the permissions for a certain profile
    DetachedCriteria criteriaProfile = DetachedCriteria
            .forClass(Profile.class);
    criteriaProfile.add(Restrictions.eq("idProfile", cp.getProfile()
            .getIdProfile()));
    criteriaProfile.createAlias("permissions", "permission");
    criteriaProfile.setProjection(Property.forName("permission.idPermission"));
    // Then we build criteria for permissions, which should match the results given by subcriteria
    DetachedCriteria criteria = DetachedCriteria
            .forClass(Permission.class);
    criteria.add(Property.forName("idPermission").in(criteriaProfile));
    List<Permission> permissions = getHibernateTemplate().findByCriteria(
            criteria);
    set.addAll(permissions);
}