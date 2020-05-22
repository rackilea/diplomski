public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.open();
    DirectoryDialog dialog = new DirectoryDialog(shell);
    dialog.setFilterPath("c:\\"); // Windows specific
    System.out.println("RESULT=" + dialog.open());
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}