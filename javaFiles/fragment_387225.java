@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Auto{
    @Id
    private int id;

    // getters, setters, ...
}

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class RaceAuto extends Auto {
    // ...
}