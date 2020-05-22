@ApplicationScoped
public class JsonSchemaValidator implements IJsonSchemaValidator {

    protected JsonValidationService jvs = JsonValidationService.newInstance();
    protected ConcurrentHashMap<String, JsonSchema> schemaMap = new ConcurrentHashMap<String, JsonSchema>();
    private Logger log = Logger.getLogger("JsonSchemaValidator");

    public JsonSchemaValidator() {
        //
    }

    private String SCHEMA_FOLDER = "schemas/";
    private String SCHEMA_LIST_FILE = "schemaList.txt";

    @PostConstruct
    public void init() {
        try {
            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
            // load file containing list of JSON schema files
            try (final InputStream is = loader.getResourceAsStream(SCHEMA_FOLDER + SCHEMA_LIST_FILE);
                    final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                    final BufferedReader br = new BufferedReader(isr)) {
                // each line is a name of a JSON schema file that has to be processed
                br.lines().forEach(line -> readSchema(line, loader));
            }
            log.info("Number of JsonSchema objects in schemaMap: " + schemaMap.size());
            log.info("Keys in schemaMap: ");
            schemaMap.forEachKey(1L, key -> log.info(key));
        } catch (Exception e) {
            throw new RuntimeException("Error trying to parse schema files!", e);
        }
    }

    private void readSchema(String schemaFileName, ClassLoader classLoader) {
        // only use part of the file name to first dot, which leaves me with "person"
        // for "person.schema.json" file name
        String schemaName = schemaFileName.substring(0, schemaFileName.indexOf("."));
        JsonSchema js = jvs.readSchema(classLoader.getResourceAsStream(SCHEMA_FOLDER + schemaFileName));
        // put JsonSchema object in map with schema name as key
        schemaMap.put(schemaName, js);
        log.info("Schema " + schemaName + " added: " + js.toJson());
    }

    @Override
    public List<Problem> validate(String json, String schemaName) {
        List<Problem> result = new ArrayList<Problem>();
        JsonSchema jsonSchema = schemaMap.get(schemaName);
        JsonReader reader = jvs.createReader(new StringReader(json), jsonSchema, ProblemHandler.collectingTo(result));
        reader.read();

        return result;
    }

    @Override
    public Map<String, JsonSchema> getLoadedSchemas() {
        return Collections.unmodifiableMap(schemaMap);
    }
}