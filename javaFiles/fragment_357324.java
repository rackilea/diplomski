@Configuration
public class HibernateConfig extends HibernateJpaAutoConfiguration {

  @Autowired
  private ValidatorFactory validator;

  @Override
  protected void customizeVendorProperties(Map<String, Object>     vendorProperties) {
    super.customizeVendorProperties(vendorProperties);
    vendorProperties.put("javax.persistence.validation.factory", validator);
  }
}