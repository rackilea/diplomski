public class post {
    public Post(long time, String name, String content) {
        super();
        this.time = time;
        this.name = name;
        this.content = content;
    }

    public String name;
    public String content;
    public long time;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public long getTime() {
        return time;
    }
}