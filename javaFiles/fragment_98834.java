public class Bean {

    private Long id;
    private String field1;
    private String field2;
    private String field3;
    // Etc... All model fields.

    @PostConstruct
    public void init() {
        // >20 lines of business/domain code to prefill the fields from DB.
    }

    public void save() {
        // >20 lines of business/domain code to save the fields in DB.
    }

    // Getters/setters for all fields and possibly also all nested fields.
}