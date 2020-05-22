public class DynamicSchemaProcessor extends FilterDynamicSchemaProcessor {

    @Override
    protected String filter(final String schemaUrl, final Util.PropertyList connectInfo, final InputStream stream) throws java.lang.Exception {
        String originalSchema = super.filter(schemaUrl, connectInfo, stream);       
        return originalSchema.replace("%SCHEMA%", schema);
    }
}