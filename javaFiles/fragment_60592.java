public class Contact {
    @PrimaryKey
    private long id;

    @Index
    private String name;

    @Index
    private String phoneNumber;

    @Index
    private boolean isBeingSaved; // this line is important

    //getters, setters
}