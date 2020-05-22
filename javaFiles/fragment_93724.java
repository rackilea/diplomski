import org.rosuda.REngine.*;
import org.rosuda.REngine.Rserve.*;

public class rserveuseClass {
    public static void main(String[] args) throws RserveException {
        try {
            RConnection c = new RConnection();// make a new local connection on default port (6311)
            double d[] = c.eval("rnorm(10)").asDoubles();
            org.rosuda.REngine.REXP x0 = c.eval("R.version.string");
            System.out.println(x0.asString());
} catch (REngineException e) {
            //manipulation
        }       

    }
}