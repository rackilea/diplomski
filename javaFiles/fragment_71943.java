// Import statements.
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

private Object executeUsingRhino(String script) throws Exception
{
    Context ctx = Context.enter();
    try
    {
        Scriptable scope = ctx.initStandardObjects();
        return ctx.evaluateString(scope, script, "<cmd>", 1, null);
    }
    finally
    {
        Context.exit();
    }
}


// Invoke a script that returns a string output using the following code snippet
String output = Context.toString(executeUsingRhino(script));