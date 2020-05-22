public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout());

    shell.addListener(SWT.DragDetect, new Listener() {
        @Override
        public void handleEvent(Event event) {
            if ((event.stateMask & SWT.ALT) != 0) {
                final DragSource dragSource = new DragSource(shell, DND.DROP_MOVE);
                dragSource.addDragListener(new DragSourceAdapter(){
                    @Override
                    public void dragFinished(DragSourceEvent event) {
                        dragSource.dispose();
                    }

                    @Override
                    public void dragSetData(DragSourceEvent event) {
                        event.data = "text";
                    }
                });
                dragSource.setTransfer(new Transfer[]{TextTransfer.getInstance()});
                dragSource.notifyListeners(SWT.DragDetect, event);

            }
        }
    });

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}