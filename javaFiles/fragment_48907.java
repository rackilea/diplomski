/** Runs the specified plugin and returns a reference to it. */
public static Object runPlugIn(String commandName, String className, String arg) {
    if (arg==null) arg = "";
    if (IJ.debugMode)
        IJ.log("runPlugIn: "+className+argument(arg));
    // Load using custom classloader if this is a user 
    // plugin and we are not running as an applet
    if (!className.startsWith("ij.") && applet==null)
        return runUserPlugIn(commandName, className, arg, false);
    Object thePlugIn=null;
    try {
        Class c = Class.forName(className);
        thePlugIn = c.newInstance();
        if (thePlugIn instanceof PlugIn)
            ((PlugIn)thePlugIn).run(arg);
        else
            new PlugInFilterRunner(thePlugIn, commandName, arg);
    }
    catch (ClassNotFoundException e) {
        if (IJ.getApplet()==null)
            log("Plugin or class not found: \"" + className + "\"\n(" + e+")");
    }
    catch (InstantiationException e) {log("Unable to load plugin (ins)");}
    catch (IllegalAccessException e) {log("Unable to load plugin, possibly \nbecause it is not public.");}
    redirectErrorMessages = false;
    return thePlugIn;
}