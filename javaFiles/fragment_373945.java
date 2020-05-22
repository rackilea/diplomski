import javax.script.ScriptEngineManager;
import javax.script.*;

public class HelloWorld{

    public static void main(String[] args) 
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        String expression = "1+2";   // evaluates to Failure: 3
        String expression = "1+a";   // evaluates to Failure:
        String expression = "1==1";  // evaluates to Success: true
        String expression = "1==2";  // evaluates to Failure: false
        try
        {
            Object result = engine.eval(expression);

            if(result instanceof Boolean)
            {
                System.out.print("Success: ");
                System.out.println(result);
            }
            else
            {
                System.out.print("Failure: ");
                System.out.println(result);
            }
        }
        catch(ScriptException e)
        {
            // handle
            System.out.println("Failure");
        }
    }
}