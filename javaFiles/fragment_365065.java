// replaces the above annotation of MyMenuItem
@ServiceProviders(value = {
    @ServiceProvider(service = ControllableMenuItem.class),
    @ServiceProvider(service = MyMenuItem.class)
})
public class MyMenuItem implements ControllableMenuItem {...}