@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SuperType {
    @SerializedName ("ct")
    protected long creationTime;
    @SerializedName ("id")
    protected String id;
}