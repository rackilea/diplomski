// Source Entity
@Entity
@Table(name = "source")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;    
    @Column
    private String name;
    @Column
    private Date date;

    // ommited getters and setters

}
// Destination entity
public class Destination {
    private Long id;
    private String name;
    private LocalDateTime localDateTime;

    // ommited getters and setters
}

// Mapping with API
jMapperAPI = new JMapperAPI();

jMapperAPI.add(mappedClass(Destination.class).add(global()
                    .excludedAttributes("localDateTime"))
                    .add(attribute("localDateTime").targetAttributes("date"))
                    .add(conversion("dateToLocalDateTime")
                            .from("date").to("localDateTime")
                            .type(JMapConversion.Type.DYNAMIC)
                            .body("java.time.Instant instant = ${source}.toInstant();" +
                                    "${destination.type} result = java.time.LocalDateTime.ofInstant(instant, java.time.ZoneId.systemDefault());" +
                                    "return result;"))
                    .add(conversion("localDateTimeToDate")
                            .from("localDateTime").to("date")
                            .type(JMapConversion.Type.DYNAMIC)
                            .body("java.time.Instant instant = ${source}.atZone(java.time.ZoneId.systemDefault()).toInstant();" +
                                    "${destination.type} result = java.util.Date.from(instant);" +
                                    "return result;")));