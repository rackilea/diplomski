if (event instanceof ActiveEvent) {
    ...
    ((ActiveEvent)event).dispatch();
} else if (src instanceof Component) {
    ((Component)src).dispatchEvent(event);
    ...
} else if (src instanceof MenuComponent) {
    ((MenuComponent)src).dispatchEvent(event);
} else if (src instanceof TrayIcon) {
    ((TrayIcon)src).dispatchEvent(event);
} else if (src instanceof AWTAutoShutdown) {
    ...
    dispatchThread.stopDispatching();
} else {
    ...
}