@Guarded
public class Person {
    private String name;
    private String surname;
    private int age;

    public Person(@NotNull String name, @NotNull String surname, @Range(min=100, max=200) int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}