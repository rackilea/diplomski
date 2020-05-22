@Entity
@EntityListeners({ UserEntityListener.class, UserPasswordValidator.class })
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Columnt(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    // getters, setters ommited

}