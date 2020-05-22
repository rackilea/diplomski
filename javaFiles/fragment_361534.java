final int optsFromDatabase = ....; // Read that combination value from DB

Map<Feature, Boolean> featureMaps = 
       Arrays.stream(Feature.values())
             .collect(toMap(f -> f, 
                            f -> (optsFromDatabase & f.getValue()) != 0,
                            (v1, v2) -> v2,
                            LinkedHashMap::new));