public class SqlFunctionsMetadataBuilderContributor 
        implements MetadataBuilderContributor {

    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction(
            "convert_tz", 
            new StandardSQLFunction( "convert_tz", StandardBasicTypes.TIMESTAMP )
        );
    }
}