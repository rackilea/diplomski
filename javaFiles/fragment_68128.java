/**
 * Adds user.dir into python.path to make Jython look for python modules in working directory in all cases
 * (both standalone and not standalone modes)
 * @param props
 * @return props
 */
private Properties setDefaultPythonPath(Properties props) {
    String pythonPathProp = props.getProperty("python.path");
    String new_value;
    if (pythonPathProp==null)
    {
        new_value  = System.getProperty("user.dir");
    } else {
        new_value = pythonPathProp +java.io.File.pathSeparator + System.getProperty("user.dir") + java.io.File.pathSeparator;
    }
    props.setProperty("python.path",new_value);
    return props;
}