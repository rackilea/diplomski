@Entity
public class Question {

    @OneToMany
    private List<Category> categories;

    // ...
}