public class PluginLoader {

    private final ServiceLoader<PluginProvider> loader;

    public PluginLoader() {

        Path pluginDir = Paths.get(System.getProperty("user.home"),
            ".local", "share", "MyApplication", "plugins");

        ModuleLayer layer = PluginProvider.class.getModule().getLayer();
        layer = layer.defineModulesWithOneLoader(
            layer.configuration().resolveAndBind(
                ModuleFinder.of(),
                ModuleFinder.of(pluginDir),
                Collections.emptySet()),
            PluginProvider.class.getClassLoader());

        loader = ServiceLoader.load(layer, PluginProvider.class);
    }

    public Stream<PluginProvider> getAll() {
        return loader.stream();
    }

    public void reload() {
        loader.reload();
    }
}