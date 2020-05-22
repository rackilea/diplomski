@PersistenceCapable(identityType = IdentityType.APPLICATION)  
public class SomeDomainClass implements Serializable {  
  @PrimaryKey  
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)  
  @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")  
  String id;
}