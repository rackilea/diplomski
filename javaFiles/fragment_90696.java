@Entity
@Table(name = "HOUSE")
public class House {

    .....

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "SUB_NUMBER")
    private String subNumber;

    @ManyToOne
    @JoinColumn(name = "TOWN_ID", nullable = false)
    private Town town;

    .....

    public House(int number, String subNumber) {
        this.number = number;
        this.subNumber = subNumber;
    }

    .....

}