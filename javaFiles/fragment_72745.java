public class LimitsControlBuilder {
    private String id ;
    private LimitsControlBuilder() {
        this.id = "" ;
    }
    public static LimitsControlBuilder create() {
        return new LimitsControlBuilder();
    }
    public LimitsControlBuilder id(String id) {
        this.id = id ;
        return this ;
    }

    public LimitsControl build() {
        return new LimitsControl(id);
    }
}