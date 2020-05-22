public List<Contract> getByPersonIdAndDates(int personId, Date initDate, Date endDate) {
    Criteria criteria = session.createCriteria(Contract.class);
    if (personId > 0) {
        criteria.add(Restrictions.eq("person.id", personId);
    }

    if (initDate != null && endDate != null) {
       criteria.add(Restrictions.between("date", initDate, endDate);
    }

    return (List<Contract>)criteria.list();
}