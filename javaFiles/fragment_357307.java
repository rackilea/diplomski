public List<Support> SearchSupportby(int appId ,String unikey,Timestamp formDate ,) {
 Criteria cr = getSession().createCriteria(Support.class, "support");
 Criterion rest1 = Restrictions.or(Restrictions.eq("support.uuId",unikey));
 Criterion rest2 = Restrictions.or(Restrictions.eq("support.applicationId",appId));
 Criterion rest3 = Restrictions.or(Restrictions.eq("support.reportDate", formDate));
 cr.add(Restrictions.and(rest1, rest2, rest3));//according to parameter you can validate it
 cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
 if (cr.list() == null || cr.list().isEmpty()) {
        return null;
    }
return cr.list();}