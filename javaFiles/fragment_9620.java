String simpleName = e.getCause().getClass().getSimpleName();
if (simpleName.equals("ClientAbortException")) {
    // ignore
} else {
    // do whatever you do
}