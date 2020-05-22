public class View {

    private final String name ;
    private final Class<?> controllerType ;

    // You could assume that the resource is name+".fxml" if you want to rely on conventions like that
    // That would eliminate the need for another field here, but would prevent
    // e.g. names with whitespace etc.
    private final String resource ;

    public View(String name, Class<?> controllerType, String resource) {
        this.name = name ;
        this.controllerType = controllerType ;
        this.resource = resource ;
    }

    public String getName() {
        return name ;
    }

    public Class<?> getControllerType() {
        return controllerType ;
    }

    public String getResource() {
        return resource ;
    }

    @Override
    public String toString() {
        return name ;
    }
}