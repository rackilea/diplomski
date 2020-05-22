// first configure your Genson instance to enable polymorphic types support and  
// serialization based on concrete types
Genson genson = new Genson.Builder()
                            .setWithClassMetadata(true)
                            .setUseRuntimeTypeForSerialization(true)
                            .create();

// and now just use it to serialize/deser
String json = genson.serialize(routineData);
RoutineData data = genson.deserialize(json, RoutineData.class);