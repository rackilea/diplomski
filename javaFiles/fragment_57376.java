private static ControllerEnvironment createDefaultEnvironment() throws ReflectiveOperationException {

    // Find constructor (class is package private, so we can't access it directly)
    Constructor<ControllerEnvironment> constructor = (Constructor<ControllerEnvironment>)
        Class.forName("net.java.games.input.DefaultControllerEnvironment").getDeclaredConstructors()[0];

    // Constructor is package private, so we have to deactivate access control checks
    constructor.setAccessible(true);

    // Create object with default constructor
    return constructor.newInstance();
}