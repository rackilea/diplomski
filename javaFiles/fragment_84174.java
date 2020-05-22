public class Person {
    private long id;
    private String name;
    @JsonSerialize(using = GenderSerializer.class)
    private Gender gender;

}