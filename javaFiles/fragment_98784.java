OrientDBConfig dbConfig = OrientDBConfig.defaultConfig();
ODatabasePoolInternal documentPoolInternal;

OrientDBEmbedded orientDBEmbedded = new OrientDBEmbedded("", dbConfig, Orient.instance());

orientDBEmbedded.create(orientDBName, username, password, ODatabaseType.MEMORY, dbConfig);

documentPoolInternal = orientDBEmbedded.openPool(orientDBName, username, password);

ODatabaseSession session = documentPoolInternal.acquire();