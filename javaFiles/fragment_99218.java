public class ComponentsWrapper {

    private Components components;

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        ComponentsWrapper components =
                objectMapper.readValue(<your JSON>),
                        ComponentsWrapper.class);


    }
}

class Components {

    private List<List<Component>> metadata;

    public List<List<Component>> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<List<Component>> metadata) {
        this.metadata = metadata;
    }
}

class Component {

    private int component;

    public int getComponent() {
        return component;
    }

    public void setComponent(int component) {
        this.component = component;
    }
}