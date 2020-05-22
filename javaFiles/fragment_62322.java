Criteria criteria = getSession().createCriteria(Car.class);
criteria.createAlias("vignettes", "V");
criteria.add(Restrictions.or(
    Restrictions.lt("V.vignetteDateFin", dateDebut),
    Restrictions.isNull("V"))
);