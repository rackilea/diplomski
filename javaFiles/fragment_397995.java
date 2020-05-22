/**
 * Shows JFace ErrorDialog but improved by constructing full stack trace in
 * detail area.
 */
public static void errorDialogWithStackTrace(String msg, Throwable t) {

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    t.printStackTrace(pw);

    final String trace = sw.toString(); // stack trace as a string

    // Temp holder of child statuses
    List<Status> childStatuses = new ArrayList<>();

    // Split output by OS-independend new-line
    for (String line : trace.split(System.getProperty("line.separator"))) {
        // build & add status
        childStatuses.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, line));
    }

    MultiStatus ms = new MultiStatus(Activator.PLUGIN_ID, IStatus.ERROR,
            childStatuses.toArray(new Status[] {}), // convert to array of statuses
            t.getLocalizedMessage(), t);

    ErrorDialog.openError(null, PxConstants.DIALOG_TITLE, msg, ms);
}