@Root(name = "rss", strict = false)
public class RSS {
    @Element
    private Channel channel;
    @Attribute
    private String version;

    public Channel getChannel() {
        return channel;
    }
}