ImmutableOpenMap<String, ImmutableOpenMap<String, AliasMetaData>> aliases = client.admin().cluster()
        .prepareState().execute()
        .actionGet().getState()
        .getMetaData().aliases();

    for (ObjectCursor<String> key: aliases.keys()) {
        ImmutableOpenMap<String, AliasMetaData> indexToAliasesMap = client.admin().cluster()
          .state(Requests.clusterStateRequest())
          .actionGet().getState()
          .getMetaData().aliases().get(key.value);

        if(indexToAliasesMap != null && !indexToAliasesMap.isEmpty()){
            String index= indexToAliasesMap.keys().iterator().next().value;
            String alias = indexToAliasesMap.values().iterator().next().value.alias();
        }
    }