@Embeddable
public class UserBanned{
    ....
}

@Entity
@Table(name = "user")
@DynamicInsert
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq")
    protected Integer id;

    @Column
    protected Integer name;

    @Embedded
    protected UserBanned userBanned;