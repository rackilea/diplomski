final int[] result = new int[] {0};

display.syncExec(new Runnable() {
    public void run() {
        Shell shell = display.getActiveShell();

        MessageDialog dialog = .... your message dialog

        result[0] = dialog.open();
    }
});

... dialog return code in result[0]