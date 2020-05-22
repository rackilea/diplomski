public ListDataModel<Contacts> qSearchContacts(String firstName, String surName, Integer countryid, Integer companyId) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Contacts> query = cb.createQuery(Contacts.class);
    Root<Contacts> cont = query.from(Contacts.class);
    query.select(cont);

    // Join<Contacts, Country> country = cont.join("country", JoinType.LEFT);
    List<Predicate> predicateList = new ArrayList<Predicate>();

    if ((firstName != null) && (!(firstName.isEmpty()))) {
        ParameterExpression<String> p
                = cb.parameter(String.class, "firstName");
        predicateList.add(cb.like(cb.upper(cont.<String>get("firstName")), "%" + firstName.toUpperCase() + "%"));

    }

    if ((surName != null) && (!(surName.isEmpty()))) {
        ParameterExpression<String> p
                = cb.parameter(String.class, "surName");
        predicateList.add(cb.like(cb.upper(cont.<String>get("surName")), "%" + surName.toUpperCase() + "%"));

    }

    if ((countryid != null) && (countryid != 0)) {
        Join<Contacts, Country> country = cont.join("country");
        ParameterExpression<Integer> ci
                = cb.parameter(Integer.class, "countryid");
        predicateList.add(cb.equal(country.get("countryid"), ci));
    }

    if ((companyId != null) && (companyId != 0)) {
        Join<Contacts, Company> company = cont.join("company");
        ParameterExpression<Integer> co
                = cb.parameter(Integer.class, "companyId");
        predicateList.add(cb.equal(company.get("companyId"), co));
    }

    if (predicateList.size() == 0) {
        query.select(cont);
    } else {
        if (predicateList.size() == 1) {
            query.where(predicateList.get(0));
        } else {
            query.where(cb.and(predicateList.toArray(new Predicate[0])));
        }
    }

    TypedQuery<Contacts> tq = em.createQuery(query);
    if (firstName != null) {
        tq.setParameter("firstName", firstName);
    }
    if (surName != null) {
        tq.setParameter("surName", surName);
    }

    if ((countryid != null) && (countryid != 0)) {
        tq.setParameter("countryid", countryid);
    }

    if((companyId != null) && (companyId != 0)) {
        tq.setParameter("companyId", companyId);
    }

    ListDataModel<Contacts> contactsResultList = new ListDataModel<Contacts>(tq.getResultList());
    return contactsResultList;

}
}