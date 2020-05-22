public interface Plugin {
    public void load(PluginConfiguration pluginConfiguration);
    public void run();
    public void unload();
    public JComponent getConfigurationPage();
}