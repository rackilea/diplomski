ApplicationWorkbenchWindowAdvisor

    @Override
    public void postWindowCreate() {
        super.postWindowCreate();
       final Shell shell = getWindowConfigurer().getWindow().getShell();
       shell.setMinimumSize(700, 800);
    }