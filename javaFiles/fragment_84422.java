public class CustomerDbConfig extends AbstractMongoConfiguration {

  ... 

  @Override
  protected Collection<String> getMappingBasePackages() {
    Collection<String> mappingBasePackages = new ArrayList<>();
    mappingBasePackages.add(Vehicle.class.getPackageName());

    return mappingBasePackages;
  }

}