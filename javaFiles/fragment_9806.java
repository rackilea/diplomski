@Entity
@Setter
@Getter
@EqualsAndHashCode(exclude = {"events"})
public class Player {
    (...)
    private String birthdayDate;
}