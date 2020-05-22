@Document(collection = "MusicGroup")
public class MusicGroup {

    @Id
    private String id;
    @Field("Title")
    private String title;
    @Field("Type")
    private String type;
    @Field("Members")
    private String[] members;

    public MusicGroup() {
    }

    @Size(min = 7, max = 7)
    public String getTitle() {
        return title;
    }

    @Size(min = 11, max = 11)
    public String getType() {
        return type;
    }

    // Other getters, setters and to String()

}