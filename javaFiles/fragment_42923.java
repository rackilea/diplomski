class Url{
    private final URL url;
    public Url() {
        url= (new File("somepath").toURI().toURL());
    }
}