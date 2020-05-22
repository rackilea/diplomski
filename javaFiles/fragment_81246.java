subprojects{
    plugins.whenPluginAdded { plugin ->
      if (plugin instanceof JavaPlugin) {
        dependencies {
          compile group: 'com.xetra11.toolbox', name: 'toolbox-commons', version: "0.0.1"
          }
        }
    }
}