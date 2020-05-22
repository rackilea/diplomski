public class MultiTenantMongoDbFactory implements MongoDbFactory {

  private PersistenceExceptionTranslator exceptionTranslator;
  private TenantDataFactory tenantDataFactory;

  public MultiTenantMongoDbFactory(TenantDataFactory tenantDataFactory) {
    this.exceptionTranslator = new MongoExceptionTranslator();
    this.tenantDataFactory = tenantDataFactory;
  }

  @Override
  public DB getDb(String dbName) throws DataAccessException {
    return getDb();
  }

  @Override
  public DB getDb() throws DataAccessException {
    Tenant tenant = TenantContext.getCurrentTenant();
    TenantData tenantData = tenantDataFactory.getTenantData(tenant);
    return MongoDbUtils.getDB(tenantData.getClient(), tenantData.getDbName());
  }

  @Override
  public PersistenceExceptionTranslator getExceptionTranslator() {
    return exceptionTranslator;
  }
}

public class TenantDataFactory {

  private Map<Tenant, TenantData> tenantDataMap;

  public TenantDataFactory(Map<Tenant, TenantData> tenantDataMap) {
    this.tenantDataMap = Collections.unmodifiableMap(tenantDataMap);
  }

  public TenantData getTenantData(Tenant tenant) {
    TenantData tenantData = tenantDataMap.get(tenant);
    if (tenantData == null) {
      // or return default tenant
      throw new IllegalArgumentException("Unsupported tenant " + tenant);
    }
    return tenantData;
  }
}

public enum Tenant {
  EAST, WEST
}

public class TenantData {

  private final String dbName;
  private final MongoClient client;

  public TenantData(String dbName, MongoClient client) {
    this.dbName = dbName;
    this.client = client;
  }

  public String getDbName() {
    return dbName;
  }

  public MongoClient getClient() {
    return client;
  }
}

public class TenantContext {

  private static ThreadLocal<Tenant> currentTenant = new ThreadLocal<>();

  public static void setCurrentTenant(Tenant tenant) {
    currentTenant.set(tenant);
  }

  public static Tenant getCurrentTenant() {
    return currentTenant.get();
  }
}

@Configuration
public class MongoConfig {

  @Bean(name = "eastMongoClient", destroyMethod = "close")
  public MongoClient eastMongoClient() {
    return new MongoClient(new ServerAddress("127.0.0.1", 27017),
        Collections.singletonList(MongoCredential.createCredential("user1", "east", "password1".toCharArray())));
  }

  @Bean(name = "westMongoClient", destroyMethod = "close")
  public MongoClient westMongoClient() {
    return new MongoClient(new ServerAddress("127.0.0.1", 27017),
        Collections.singletonList(MongoCredential.createCredential("user2", "west", "password2".toCharArray())));
  }

  @Bean
  public TenantDataFactory tenantDataFactory(@Qualifier("eastMongoClient") MongoClient eastMongoClient,
                                             @Qualifier("westMongoClient") MongoClient westMongoClient) {
    Map<Tenant, TenantData> tenantDataMap = new HashMap<>();
    tenantDataMap.put(Tenant.EAST, new TenantData("east", eastMongoClient));
    tenantDataMap.put(Tenant.WEST, new TenantData("west", westMongoClient));
    return new TenantDataFactory(tenantDataMap);
  }

  @Bean
  public MongoDbFactory mongoDbFactory(@Autowired TenantDataFactory tenantDataFactory) {
    return new MultiTenantMongoDbFactory(tenantDataFactory);
  }

  @Bean
  public MongoTemplate mongoTemplate(@Autowired MongoDbFactory mongoDbFactory) {
    return new MongoTemplate(mongoDbFactory);
  }
}