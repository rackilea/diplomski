public class PluginTestCase {

    @Test
    public void showView() {
        Display display = PlatformUI.getWorkbench().getDisplay();
        Shell shell = display.getActiveShell();
        // Create a new thread
        Thread thread = new Thread(() -> {
            runUICode(display);
        });
        thread.start();

        // Enter the UI message loop
        while (!shell.isDisposed() && thread.isAlive()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Runs the code in a separate thread.
     * 
     * @param display
     *            the display which handles UI modifications
     */
    private void runUICode(Display display) {
        closeIntro(display);
        showView(display, "org.eclipse.jdt.debug.ui.DisplayView");
        showView(display, "org.eclipse.debug.ui.MemoryView");
    }

    /**
     * Closes the introduction part.
     */
    private void closeIntro(Display display) {
        display.syncExec(new Runnable() {
            @Override
            public void run() {
                IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
                PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
            }
        });
    }

    /**
     * Shows view of the given ID in the current perspective. The view gets
     * focus (is selected).
     * 
     * @param display
     *            the display object
     * @param viewId
     *            the ID of the view to be shown
     */
    private void showView(Display display, String viewId) {
        display.syncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    // Show and select the view
                    activePage.showView(viewId);
                } catch (WorkbenchException e) {
                    throw new IllegalStateException(e);
                }
            }

        });
    }
}