public class StartupHook implements IStartup {
    @Override
    public void earlyStartup() { 
        IWorkbenchWindow window = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
        ISelectionListener projectListener = new ProjectSelectionListener();
        window.getSelectionService().addSelectionListener(projectListener);
    }

}