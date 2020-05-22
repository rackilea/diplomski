TitanFactory.Builder config = TitanFactory.build();
config.set("storage.backend", "berkeleyje");
config.set("storage.directory", DIRECTORY + File.separator + "berkeleyje");
config.set("index." + INDEX_NAME + ".backend", "lucene");
config.set("index." + INDEX_NAME + ".directory", DIRECTORY + File.separator + "lucene");
graph = config.open();