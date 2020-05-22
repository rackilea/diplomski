public class DefaultCompanyProvider implements CompanyProvider {
    public Company get(String companyId) {
        companyIdValidator.validate(companyId);

        // retrieve / create the company
        return company;
    }
}