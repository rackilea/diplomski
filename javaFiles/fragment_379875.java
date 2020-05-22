// wrapper-my-api.jar
public class NotFunnyMyAPIFactory implements MyAPIFactory {
    private Config config;

    public MyAPI getImplementationOfMyAPI() {
        if (config.implType == GREEN) {
            return new GreenMyAPI();
        } else if (config.implType == BLACK) {
            return new BlackMyAPI();                
        } else if (config.implType == RED) {
            return new RedMyAPI();                
        } else { 
           // throw...
        }
    }
}

public class ReflectionMyAPIFactory implements MyAPIFactory {
    private Properties prop;

    public MyAPI getImplementationOfMyAPI() {
        return (MyAPI) Class.forName(prop.get('myApi.implementation.className'))
    }
}

// other possible strategies