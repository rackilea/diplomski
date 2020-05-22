@Data
@Entity
@JsonSnakeCase
public class WorkingHours {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "fcId", referencedColumnName="fcid")
    private Warehouse warehouse;

    private LocalDate date;
    private DateTime start;
    private DateTime end;
}