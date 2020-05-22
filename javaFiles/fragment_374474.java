public class Workspace {
    final ObjectMapper objMapper = new ObjectMapper();
    List<Product> products;

    public Workspace() {
    }

    public Workspace(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String serialize() throws IOException {
        try {
            return objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Workspace deserialize(String json) throws IOException {
        return new ObjectMapper().readValue(json, Workspace.class);
    }        
}

public class Product {
    List<Module> modules;

    public Product() {
    }

    public Product(List<Module> modules) {
        this.modules = modules;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}


public class Module {
    List<Parameter> parameters;

    public Module() {
    }

    public Module(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }      
}

public class Parameter {
    String name;
    String type;

    public Parameter() {
    }

    public Parameter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }      
}

public class WorkspaceTest {        
    /**
     * Test of serialize method, of class Workspace.
     */
    @Test
    public void testSerDeserialize() throws Exception {
        // Build sample:
        Workspace instance = new Workspace(
                Collections.singletonList(new Product(
                        Collections.singletonList(new Module(
                            Collections.singletonList(new Parameter("Hello","World")))))));

        // SER
        String serialized = instance.serialize();        
        assertNotNull(serialized);
        System.out.println("Serialized JSON: \n"+serialized);

        // DSER
        Workspace deserialized = Workspace.deserialize(serialized);            

        // MATCH
        assertEquals(serialized, deserialized.serialize());
        System.out.println("Match!");
    }
}