private static final Logger comGithubHervian_LOGGER = LoggingHelper.getLogger(ClassWithLogAnnotatedMethods.LogAround_log1ArgumentAndThis.class);
private static final String = comGithubHervian_CLASSNAME = ClassWithLogAnnotatedMethods.LogAround_log1ArgumentAndThis.class.getName();

public String execute(String arg1) {
    if (LoggingHelper.isEntryExitTraceEnabled((Logger)comGithubHervian_LOGGER)) {
        comGithubHervian_LOGGER.entering(comGithubHervian_CLASSNAME, "execute", new Object[]{arg1, this});
    }
    /*Some logic*/
    String string = "done";
    if (LoggingHelper.isEntryExitTraceEnabled((Logger)comGithubHervian_LOGGER)) {
        comGithubHervian_LOGGER.exiting(comGithubHervian_CLASSNAME, "execute", string);
    }
    return string;
}