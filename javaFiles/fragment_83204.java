public abstract class TestUtilityFunctions<T implements CommonProperties> {
    private final T props;
    protected TestUtilityFunctions(T props) {
        this.props = props;
    }
    protected void initRestAssured() {
        // are PORT and BASE_URL static? 
        // if no, they shouldn't be capitals (use getPort() and getBaseUrl())
        // if yes, this is bad design
        RestAssured.port = props.PORT;
        RestAssured.basePath = props.BASE_URL;
    }
}