class CachedPool {
    private Map<URI, CachedFile> pool = new HashMap<>();

    public CachedPool(){
    }

    public <T> T getResource(URI uri) {
        CachedFile file;
        if(pool.containsKey(uri)){
            file = pool.get(uri);
        } else {
            file = new CachedFile(uri);   // Injecting point to add resources
            pool.put(uri, file);
        }
        return file.getContent();
    }
}

class CachedFile {
    private URI uri;
    private int counter;
    private Date cachedTime;
    private Object content;

    public CachedFile(URL uri){
        this.url = uri;
        this.content = uri.toURL().getContent();
        this.cachedTime = new Date();
        this.counter = 0;
    }

    public <T> T getContent(){
        counter++;
        return (T) content;
    }

    /** Override equals() and hashCode() **/
    /** Write getters for all instance variables **/
}