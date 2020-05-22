public class ImmutablesAlignmentRule implements ComponentMetadataRule {
    private final Logger log = LoggerFactory.getLogger( this.getClass() );

    @Override
    public void execute( ComponentMetadataContext ctx ) {
        ComponentMetadataDetails details = ctx.getDetails();
        ModuleVersionIdentifier module = details.getId();
        details.allVariants( vm -> {
            String group = "org.immutables";
            log.trace( "checking for immutables: {}", module );
            if ( Objects.equals( module.getGroup(), group ) ) {
                details.belongsTo( group + ":platform:" + module.getVersion(), true );
                log.info( "aligning immutables: {}", module );
            }
        } );
    }
}