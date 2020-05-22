/* Class members */
@Parameter(defaultValue="${project}",required=true, readonly=true)
protected MavenProject project;

@Parameter( defaultValue = "${session}", required = true, readonly = true )
protected MavenSession session;

@Component( role=org.apache.maven.shared.filtering.MavenResourcesFiltering.class, hint="default")
protected MavenResourcesFiltering mavenResourcesFiltering;

@Parameter( property = "encoding", defaultValue = "${project.build.sourceEncoding}" )
protected String encoding;

@Parameter
protected List<Resource> resources;


...

//Inside my plugin's execute() method: 
List<String> nonFilteredFileExtensions = new ArrayList<String>();
//resources is a parameter to my plugin, dir and filters are calculated within the plugin
MavenResourcesExecution mre = new MavenResourcesExecution(resources, dir, this.project, this.encoding, filters, nonFilteredFileExtensions, session);
mavenResourcesFiltering.filterResources(mre);