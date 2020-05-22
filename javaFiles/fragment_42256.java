final java.net.URL Loc = new URL("http://.../Mass-Effect.png");
Thread t = new Thread(new Runnable() {
    public void run() {
        Object content = Loc.getContent();
        // content would be probably some Image class or byte[]

        // or:
        // InputStream in = Loc.openStream();
        // read image from in
    }
);