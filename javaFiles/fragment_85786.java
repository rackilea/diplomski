@PersistenceCapable
public class BuddyData {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    Key key;

    // use Key instead of MyInfoClass
    @Persistent
    private Key myInfoClass;
}