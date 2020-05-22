import org.gradle.tooling.BuildLauncher;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.File;

public class ToolingAPI
{
    private static final String GRADLE_INSTALLATION = "C:\\Program Files\\Gradle";
    private static final String GRADLE_PROJECT_DIRECTORY = "path_to_root_of_a_gradle_project";
    private static final String GRADLE_TASK = "help";

    private GradleConnector connector;

    public ToolingAPI(String gradleInstallationDir, String projectDir)
    {
        connector = GradleConnector.newConnector();
        connector.useInstallation(new File(gradleInstallationDir));
        connector.forProjectDirectory(new File(projectDir));
    }

    public void executeTask(String... tasks)
    {
        ProjectConnection connection = connector.connect();
        BuildLauncher build = connection.newBuild();
        build.forTasks(tasks);

        build.run();
        connection.close();
    }

    public static void main(String[] args)
    {
        ToolingAPI toolingAPI = new ToolingAPI(GRADLE_INSTALLATION, GRADLE_PROJECT_DIRECTORY);
        toolingAPI.executeTask(GRADLE_TASK);
    }
}