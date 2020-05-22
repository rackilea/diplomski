Listener listener = new Listener() {
    public void handleEvent(Event event) {
        System.out.println(event.character);
    }
}
getShell().getDisplay().addFilter(SWT.KeyDown, listener);