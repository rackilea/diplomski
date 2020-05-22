ProgressMonitorDialog dialog = new ProgressMonitorDialog(getShell()) {
    @Override
    protected void configureShell(Shell shell) {
      super.configureShell(shell);
      shell.setText("Dialog title");
    }
};

try {
   dialog.run(true, true, progress);
}   
... catches ...