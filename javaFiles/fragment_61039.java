@Mojo(name = "svn-info", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
@Execute(phase = LifecyclePhase.PROCESS_SOURCES)
public class SvnInfoMojo extends AbstractMojo {
    @Component
    private MavenProject project;
    @Parameter(property="project.scm.url", defaultValue = "${project.scm.url}", required = true)
    private String url;
    private String svnLastRevision;
    private String svnLastChangedDate;

    public void execute() throws MojoExecutionException, MojoFailureException {
        SVNController controller = new SVNController(url);
        info = controller.getInfo();

        this.svnLastRevision = Long.toString(info.getCommittedRevision().getNumber());
        // Sets the property ${last-rev} in the project pom
        project.getProperties().setProperty("last-rev", this.svnLastRevision);

        // uses DateFormat to parse the date
        this.svnLastChangedDate = parseDate(info.getCommittedDate());
        // Sets the property ${last-changed} in the project pom
        project.getProperties().setProperty("last-changed", this.svnLastChangedDate);
    }
}