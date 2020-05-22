Display display = new Display();
Shell shell = new Shell(display);
// Define message box
shell.open();
while (!shell.isDisposed()) {
    if (display.readAndDispatch()) {
        display.sleep();
    }
}
display.dispose();