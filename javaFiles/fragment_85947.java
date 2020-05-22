@Singleton
@Component(modules = MyModule.class)
public interface MyComponent{
    @Named("sourceConnection")
    ConnectionDTO sourceConnectionDTO();

    @Named("destinationConnection")
    ConnectionDTO destinationConnectionDTO();
}