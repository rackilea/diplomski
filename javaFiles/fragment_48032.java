IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint extensionPoint = registry
            .getExtensionPoint("myplugin.myextension");
    IConfigurationElement points[] = extensionPoint
            .getConfigurationElements();
    for (IConfigurationElement point : points) {
        if ("myextensionFactory".equals(point.getName())) {
            Object impl = point.createExecutableExtension("class");
            if (impl instanceof IMyExtension) {
                ((IMyExtension) impl).foo();
            }
        }
    }
}