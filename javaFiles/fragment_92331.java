deserialize {test:[0,3]} as int[]
// --> Gson finds ArrayDeserializer mapped to int[]
take given JSON as an object (OK), extract 'test' as JSON array (OK)
deserialize [0,3] as int[]
// --> Gson finds ArrayDeserializer mapped to int[]
take given JSON as an object (FAIL)