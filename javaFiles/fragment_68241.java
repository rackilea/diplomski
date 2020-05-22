CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Site> q = cb.createQuery(Site.class);
    Root<Site> e = q.from(Site.class);
    Join<Site,SiteType> siteType = e.join(Site_.siteType);

    Predicate predicate = cb.conjunction();
    Predicate p1 = cb.equal(siteType.get(SiteType_.id), selectedSiteType.getId());
    Predicate p2 = cb.equal(e.get(Site_.markedAsDeleted), false);
    predicate = cb.and(p1,p2);

    q.where(predicate);     
    q.select(e);

    TypedQuery<Site> tq = entityManager.createQuery(q);
    List<Site> all = tq.getResultList();

    return all;