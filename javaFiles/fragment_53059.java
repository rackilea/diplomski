Display.getCurrent().timerExec( 1000, () -> process() );

private void process(){
    // do some stuff...
    Display.getCurrent().timerExec( 1000, () -> process() );
}