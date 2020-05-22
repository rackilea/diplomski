@Entity
@Table(name="COUNTRY")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="COUNTRY_ID", nullable = false)
    private Integer country_id;

    @Column(name="COUNTRY_CODE")
    private String country_code;
    //Add getter and setter
}