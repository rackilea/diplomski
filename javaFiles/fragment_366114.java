import java.io.IOException;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.util.ResourceUtils;
import org.apache.tools.ant.types.resources.LogOutputResource;
import org.apache.tools.ant.types.resources.StringResource;


public class MyLogTask extends Task {
    private String msg;

    public void execute() throws BuildException {
        try {
            ResourceUtils.copyResource(new StringResource(msg), new LogOutputResource(this, Project.MSG_ERR),
                                  null, null, false, false, true, null, null, getProject(), true);
        } catch (IOException ioe) {
            throw new BuildException(ioe, getLocation());
        }
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }
}