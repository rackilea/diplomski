@Override
public void start(Stage stage)
throws ReflectiveOperationException {

    String serverClassName = getParameters().getRaw().get(0);

    Class<? extends ServerInstance> serverClass =
        Class.forName(serverClassName).asSubclass(ServerInstance.class);

    this.server = serverClass.getConstructor().newInstance();
}