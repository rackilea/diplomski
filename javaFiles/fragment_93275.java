public class DependencyManagement implements Plugin<Project> {
    private final Logger log = LoggerFactory.getLogger( this.getClass() );
    private final String platform = "org.springframework.boot:spring-boot-starter-parent:2.1.+";
    private final List<String> scopes = Arrays.asList( APT, COMPILE, IMPL, TEST_COMPILE );


    private static String immutables( String artifact ) {
        return String.join( D, "org.immutables", artifact, "2.+" );
    }

    @Override
    public void apply( Project project ) {
        log.info( "starting plugin {} for: {}", this.getClass().getSimpleName(), project.getName() );

        project.getConfigurations().all( conf -> {
            conf.resolutionStrategy( rs -> rs.cacheChangingModulesFor( 1, TimeUnit.MINUTES ) );
        } );

        DependencyHandler deps = project.getDependencies();
        deps.components( cmh -> cmh.all( ImmutablesAlignmentRule.class ) );
        scopes.forEach( scope -> deps.add( scope, deps.enforcedPlatform( platform ) ) );
        deps.constraints( dch -> {
            scopes.forEach( scope -> {
                Stream.of( "value", "builder" ).forEach( artifact -> dch.add( scope, immutables( artifact ) ) );
            } );
            dch.add( TEST_IMPL, String.join( D, EqualsVerifier.G, EqualsVerifier.A, EqualsVerifier.V ) );
            dch.add( IMPL, "com.google.guava:guava:" + LATEST );
        } );
    }
}