@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(ScheamValidatorProperties.class)
public class SchemaValidatorApplication {
     public static void main(String[] args) {
       SpringApplication.run(SchemaValidatorApplication.class, args);
    }
}

@ConfigurationProperties("schema-validator")
class ScheamValidatorProperties {
    public Map<String, String> settings = new HashMap<>();

    public ScheamValidatorProperties() {
    }

    public Map<String, String> getSettings() { 
        return this.settings;
    }

    public void setSome(Map<String, String> settings) { 
        this.settings = settings;
    }
}

@Component
class ScheduledSchemaValidator {

    private ScheamValidatorProperties props;

    public ScheduledSchemaValidator(ScheamValidatorProperties props) {
        this.props = props;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void validateSchema() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(props.getSettings())
            .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
            .addAnnotatedClass(Entity1.class)
            .addAnnotatedClass(Entity2.class)
            .buildMetadata();

        try {
            new SchemaValidator().validate(metadata, serviceRegistry);
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        } finally {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
}

@Entity
@Table(name = "table1")
class Entity1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Entity1() {}

    public Long getId() {
        return id;
    }

}

@Entity
@Table(name = "table2")
class Entity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Entity2() {}

    public Long getId() {
        return id;
    }
}