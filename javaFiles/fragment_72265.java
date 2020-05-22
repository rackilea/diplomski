@Entity
    public class Country {
        @Id@GeneratedValue@AccessType("property")
        private Integer id;

        private String name;