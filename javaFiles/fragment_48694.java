Company company = companyRepo.getUsersCompany(memberId);
    if (company == null) return null;
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Offer> query = cb.createQuery(Offer.class);
    Root<Offer> root = query.from(Offer.class);
    Long companyId = company.getId();
    query = query.select(root).where(cb.equal(root.get(Offer_.companyID), companyId));
    return em.createQuery(query).getResultList();