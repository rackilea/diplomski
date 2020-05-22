@Transactional
public Company fetchTestCompany() {
    TypedQuery<Company> query = this.getEntityManager().createNamedQuery("Company.profile.view.byId", Company.class);
    query.setParameter("companyId", 123);

    try {
        Company company = query.getSingleResult();
        Hibernate.initialize(company.getCompanyServices());

        return company;
    } catch (NoResultException nre) {
        return null;
    }
}