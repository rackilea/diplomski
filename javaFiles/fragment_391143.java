String[] allowedFlavours = { "chocolate", "banana"};
Criteria criteria = getSession().createCriteria(IceCream.class);
criteria.add(Restrictions.disjunction().add(Restrictions.in("flavour", allowedFlavours)).add(Restrictions.isNull("flavour"));


return criteria.list();