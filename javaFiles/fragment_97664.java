public class XMLDMultiTenantConnectionProvider extends AbstractMultiTenantConnectionProvider {


      private final ConnectionProvider xml1 = ConnectionProviderBuilder.buildConnectionProvider("xml1DataSource");
      private final ConnectionProvider xml2 = ConnectionProviderBuilder.buildConnectionProvider("xml2DataSource");

    /**
     * 
     */
    private static final long serialVersionUID = -6679645015449636823L;

    @Override
    protected ConnectionProvider getAnyConnectionProvider() {
         //Default Datasource (in this case i chose the first one as default)
         return xml1;
    }

    @Override
    protected ConnectionProvider selectConnectionProvider(String tenantIdentifier) {

    if( "xml1".equals(tenantIdentifier) ) 
        return xml1;

    if( "xml2".equals(tenantIdentifier) ) 
        return xml2;

    return null;
    }

}