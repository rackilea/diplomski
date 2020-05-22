import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;

public class existTemplate {
    private VelocityEngine engine;
    public existTemplate(VelocityEngine e) {
        engine =new VelocityEngine();
        engine = e;
    }

    public boolean exists(String name)
    {
        try
        {
            // checks for both templates and static content
            return engine.resourceExists(name);
        }
        // make sure about this...
        catch (ResourceNotFoundException rnfe)
        {
            return false;
        }
        catch (NullPointerException rnfe)
        {
            return false;
        }
    }

}