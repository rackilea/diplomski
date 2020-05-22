public class CompanyIdToInstanceConverter implements Converter<String, Company> {

    @Inject
    private CompanyService _companyService;

    @Override
    public Company convert(final String companyIdStr) {
        return _companyService.find(Long.valueOf(companyIdStr));
    }

}