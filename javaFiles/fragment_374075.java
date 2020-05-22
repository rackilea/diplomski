public class OuterClass{

    @PrimaryKey
    private String id;

    @Persistent
    private String name;

    // --- blah blah
    @PersistenceCapable( table="NestedClass")
    @Embedded
    static class NestedClass{
        //--- properties declaration
    }
}