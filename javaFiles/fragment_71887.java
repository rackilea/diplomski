@WebServlet( "/fhir/*" )
public class FhirServlet extends RestfulServer {

    private static final long serialVersionUID = 3341258540126825379L;
    private final WebApplicationContext myAppCtx;

    public FhirServlet( WebApplicationContext myAppCtx ) {
        this.myAppCtx = myAppCtx;
    }

    @Override
    protected void initialize() throws ServletException {
        this.setFhirContext( FhirContext.forDstu3() );
        this.setServerAddressStrategy( new IncomingRequestAddressStrategy() );
        this.setDefaultPrettyPrint( true );
        this.setDefaultResponseEncoding( EncodingEnum.JSON );
        this.setETagSupport( ETagSupportEnum.ENABLED );

        /*
         * The BaseJavaConfigDstu3.java class is a spring configuration
         * file which is automatically generated as a part of hapi-fhir-jpaserver-base and
         * contains bean definitions for a resource provider for each resource type
         */
        List<IResourceProvider> beans = myAppCtx.getBean( "myResourceProvidersDstu3", List.class );
        setResourceProviders( beans );

        /*
         * The system provider implements non-resource-type methods, such as
         * transaction, and global history.
         */
        setPlainProviders( myAppCtx.getBean( "mySystemProviderDstu3", JpaSystemProviderDstu3.class ) );

        /*
         * The conformance provider exports the supported resources, search parameters, etc for
         * this server. The JPA version adds resource counts to the exported statement, so it
         * is a nice addition.
         */
        IFhirSystemDao<Bundle, Meta> systemDao = myAppCtx.getBean( "mySystemDaoDstu3", IFhirSystemDao.class );
        JpaConformanceProviderDstu3 confProvider = new JpaConformanceProviderDstu3( this, systemDao, myAppCtx.getBean( DaoConfig.class ) );
        confProvider.setImplementationDescription( "Example Server" );
        setServerConformanceProvider( confProvider );

        /*
         * This server tries to dynamically generate narratives
         */
        getFhirContext().setNarrativeGenerator( new DefaultThymeleafNarrativeGenerator() );

        /*
         * -- New in HAPI FHIR 1.5 --
         * This configures the server to page search results to and from
         * the database, instead of only paging them to memory. This may mean
         * a performance hit when performing searches that return lots of results,
         * but makes the server much more scalable.
         */
        setPagingProvider( myAppCtx.getBean( DatabaseBackedPagingProvider.class ) );

        /*
         * Load interceptors for the server from Spring (these are defined in FhirServerConfig.java)
         */
        Collection<IServerInterceptor> interceptorBeans = myAppCtx.getBeansOfType( IServerInterceptor.class ).values();
        for ( IServerInterceptor interceptor : interceptorBeans ) {
            this.registerInterceptor( interceptor );
        }

        /*
         * If you are hosting this server at a specific DNS name, the server will try to
         * figure out the FHIR base URL based on what the web container tells it, but
         * this doesn't always work. If you are setting links in your search bundles that
         * just refer to "localhost", you might want to use a server address strategy:
         */
        //setServerAddressStrategy(new HardcodedServerAddressStrategy("http://example.com/fhir/baseDstu2"));

        /*
         * If you are using DSTU3+, you may want to add a terminology uploader, which allows
         * uploading of external terminologies such as Snomed CT. Note that this uploader
         * does not have any security attached (any anonymous user may use it by default)
         * so it is a potential security vulnerability. Consider using an AuthorizationInterceptor
         * with this feature.
         */
        registerProvider( myAppCtx.getBean( TerminologyUploaderProviderDstu3.class ) );
    }
}