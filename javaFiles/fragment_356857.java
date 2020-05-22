@Entity
public class Person {
    @OneToOne
    private Dog dog;

    @OneToMany
    private List<Email> emailList;
}