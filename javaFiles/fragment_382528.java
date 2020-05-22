MongoClient mongoClient = new MongoClient("GSI-547576", 27017);
MongoDatabase database = mongoClient.getDatabase("test");
MongoCollection < Document > table = database.getCollection("fc");
FreightCompanyDao freightCompanyDao = new FreightCompanyDaoImpl(DataSourceFactory.getDataSource(DatabaseType.POSTGRES.name()));
List < FreightCompany > freightCompanies = freightCompanyDao.getAllFreightCompanies();

for (FreightCompany company: freighetCompanies) {
    Document doc = Document.parse(GenericUtils.toJson(company))
    collection.insertOne(doc)
}