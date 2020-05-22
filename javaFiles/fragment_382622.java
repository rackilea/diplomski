class WindowMonitor implements AWTEventListener {
    public void eventDispatched(AWTEvent event) {
        switch (event.getID()){
            case WindowEvent.WINDOW_OPENED:
                doSomething();
                break;
            case WindowEvent.WINDOW_CLOSED:
                doSomethingElse();
                break;
        }
    }

    // ...
}

class MyClass {

    // alternative 1
    public void registerListener() {
        Toolkit.getDefaultToolkit().addAWTEventListener(new WindowMonitor(),
                AWTEvent.WINDOW_EVENT_MASK);
    }

    // alternative 2
    public void registerListener(Component component) {
        component.getToolkit().addAWTEventListener(new WindowMonitor(),
                AWTEvent.WINDOW_EVENT_MASK);
    }
}