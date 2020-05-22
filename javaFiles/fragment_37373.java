import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.Project;
import java.io.*;

public class Greeting extends DefaultTask {
    private String message;
    private String recipient;
    private File projectDir;
    private Project project;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public File getProjectDir() { return projectDir; }
    public void setProjectDir(File projectDir) { this.projectDir = projectDir; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    @TaskAction
    void sayGreeting() {
        System.out.printf("%s, %s, %s!\n", getProject().getRootDir().toString(), getMessage(), getRecipient()); 
    }       
}