public class ProjectDataSource extends AbstractDataSource {
    @Autowired ToolService toolService;

    @ConfigurationProperties(prefix = "project.datasource")
    private DataSource determineTargetDataSource() {
        String projectName = toolService.get().getProjectName();
        ...
    }