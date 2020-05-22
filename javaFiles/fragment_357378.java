@Entity
@Table(name = "user")
public class EUser
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Max( value=Integer.MAX_VALUE )
    private Long myId;

    @Column(name = "email")
    @Size(max=64)
    @NotNull
    private String myEmail;

    ...
}