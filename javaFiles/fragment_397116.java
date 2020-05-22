public class BaseSystemManager<T extends System> {
    private List<T> systems = new ArrayList<>();

    public void addSystem(T system) {
        systems.add(system);
    }

    // common methods
}

public class SystemManager extends BaseSystemManager<System> {
    // methods specific to System handling
}

public RenderSystemManager extends BaseSystemManager<RenderSystem> {
    // methods specific to RenderSystem handling
}