public final class CachedText implements Text{

    private final Text origin;

    private String result;

    public CachedText(final Text orgn) {
        this.origin = orgn;
    }

    @Override
    public String asText() throws IOException {
        if(this.result == null){
            synchronized(this) {
                if(this.result == null){
                    this.result = this.origin.asText();
                }
            }
        }
        return this.result;
    }

}