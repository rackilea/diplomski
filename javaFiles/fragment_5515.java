final List<Company> companies = new ArrayList<Company>();

csvParser.process(inputStream, Company.class, new RecordHandler<Company>() {
    @Override
    public void execute(Company imported, int rowNumber, Map supplementaryInfo) {
        companies.add(imported);
    }
});