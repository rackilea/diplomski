ClusterStateRequest clusterStateRequest = Requests.clusterStateRequest()
            .routingTable(false)
            .nodes(false)
            .indices("your_index_name_goes_here");

    ObjectLookupContainer<String> setAliases= client
            .admin().cluster().state(clusterStateRequest)
            .actionGet().getState().getMetaData()
            .aliases().keys();