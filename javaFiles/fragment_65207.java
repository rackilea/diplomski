ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
for (String sqlScript: sqlInitializationScripts ) {
  Resource sqlScriptResource = RESOURCE_LOADER.getResource(sqlScript);
  populator.addScript(sqlScriptResource);
}
DatabasePopulatorUtils.execute(populator, dataSource);