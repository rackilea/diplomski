@Root
public class Programme {


    @Attribute(name = "channel", required = false)
    private final String channel;

    @Attribute(name = "start", required = false)
    private final String start;

    @Attribute(name = "stop", required = false)
    private final String stop;


    @Element(name = "title", type = Title.class, required = false)
    private Title title;

    @Element(name = "desc", type = Desc.class, required = false)
    private Desc desc;

    public Programme(
            @Attribute(name = "channel") String channel,
            @Attribute(name = "start") String start,
            @Attribute(name = "stop") String stop
    ) {
        this.channel = channel;
        this.start = start;
        this.stop = stop;
        this.title = new Title();
        this.desc = new Desc();
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }


    @Root(name = "title")
    public static class Title {
        public String text;
        @Attribute(name = "lang")
        private String lang;

        @Text
        public String getText() {
            return text;
        }

        @Text
        public void setText(String text) {
            this.text = text;
        }

        public String getLang() {
            return lang;
        }
    }

    @Root(name = "desc")
    public static class Desc {
        public String text;
        @Attribute(name = "lang")
        private String lang;

        @Text
        public String getText() {
            return text;
        }

        @Text
        public void setText(String text) {
            this.text = text;
        }

        public String getLang() {
            return lang;
        }
    }

}