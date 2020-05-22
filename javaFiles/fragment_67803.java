DetachedCriteria accessCriteria = DetachedCriteria.forClass(Access.class)
         .setProjection(Property.forName("code"))
         .add(Restrictions.eq("appCode", "P"))
         .add(Restrictions.eq("catId", dymanicParam));

DetachedCriteria permCriteria = DetachedCriteria.forClass(Perm.class)
         .setProjection(Property.forName("appNo"))
         .add(Property.forName("code").in(accessCriteria))

DetachedCriteria criteria = DetachedCriteria.forClass(HDR.class)
         .add(Property.forName("app_no").in(permCriteria))

// criteria.getExecutableCriteria(session).list();