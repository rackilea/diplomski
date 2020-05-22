if (checkIfElasticSearchIndexExists(index)) { //NOT THREAD SAFE
            LOG.error("Cannot recreate already existing index: " + index);
            return false;
        }
        if (elasticConfig == null || elasticConfig.equals(BatchConstants.EMPTY_STRING)) { //NOT THREAD SAFE
            loadElasticConfigFromFile(ELASTIC_CONFIG_FILE_NAME);
        }
        if (elasticConfig != null && !elasticConfig.equals("")) { //NOT THREAD SAFE