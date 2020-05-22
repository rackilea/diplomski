public TourOffice findOfficeNameByLogin(String username) {
    Criteria name = createCriteria();
    name.createAlias("login", "login");
    name.add(Restrictions.eq("login.username", username));
    return (TourOffice) name.uniqueResult();
}