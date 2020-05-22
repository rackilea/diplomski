@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MPTTObject {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String encodedKey;

    @Persistent
    private String parentEncodedKey;

    @Persistent
    private int left;

    @Persistent
    private int right;