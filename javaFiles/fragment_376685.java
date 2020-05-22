public class SomeHandler {
    protected MToolItem toolItem;

    @CanExecute
    @Inject
    public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional ISelection selection)
    {
        boolean canExecute = ...
        setToolItemVisible(canExecute);
        ...
    }

    private void setToolItemVisible(final boolean visible) {
        if (toolItem != null) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    toolItem.setVisible(visible);
                }
            });
        }
    }
}