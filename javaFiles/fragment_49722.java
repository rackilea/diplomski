public class UserActivity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long entityId;

    @ManyToOne
    @JoinColumn(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    CustomerEntity user;
..................
}