ThreadLocal<ConcurrentHashMap<String, String>> tl = ...

// ...

final ConcurrentHashMap<String, String> props = tl.get();

EventQueue.invokeLater(new Runnable() {
    public void run() {
        props.add(key.getText(), val.getText());
    }
});