public class CustomDataTypesRegistration implements SessionFactoryBuilderFactory {

private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomDataTypesRegistration.class);

@Override
public SessionFactoryBuilder getSessionFactoryBuilder(final MetadataImplementor metadata, final SessionFactoryBuilderImplementor defaultBuilder) {
    logger.info("Registering custom Hibernate data types");
    //Deprecated. (since 5.3) No replacement, access to and handling of Types will be much different in 6.0
    metadata.getTypeResolver().registerTypeOverride(new OoStringType());
    return defaultBuilder;
}}