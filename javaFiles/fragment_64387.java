/**
     * This function takes in a JSON node, a type info and converts the JSON into 
     * the given type.
     * @param node - node to deserialize
     * @param typeInfo - data type to deserialize into
     * @throws JsonMappingException
     * @throws JsonParseException
     * @throws IOException
     */
    private void deserializeNode ( JsonNode node, Type typeInfo ) throws JsonMappingException, JsonParseException, IOException {

        Object deserializedValue = null;

        if ( node.isDouble()   ) {
            deserializedValue = node.asDouble();

        } else if ( node.isInt() ) {
            deserializedValue = node.asInt();

        } else if ( node.isLong() ) {
            deserializedValue = node.asLong();

        } else if ( node.isBoolean() ) {
            deserializedValue = node.asBoolean();

        } else if ( node.isArray() ) {
            //Json array is translated into a Java List. If this is a known type, it will translate
            //into a List<Type> instance.
            CollectionType collectionType = this.getActualTypeOfCollection( typeInfo );
            deserializedValue = mapper.readValue( node.toString(),  collectionType );

        } else if ( node.isObject() ) {
            JavaType objectType = mapper.getTypeFactory().constructType( typeInfo );
            deserializedValue = mapper.readValue( node.toString(), objectType );

        } else if ( node.isTextual() ) {
            deserializedValue = node.asText();

        } 

        this.deserializedValues.add( deserializedValue );

    }


    /**
     * This function returns the actual collection type of a generic parameter.
     * I.e. It returns the proper Collection data complete with the generic type so
     * that Jackson could determine the proper type to deserialize the field into.
     * @param genericParameterType - java parameter type
     * @return Jackson collection type
     */
    private CollectionType getActualTypeOfCollection ( Type genericParameterType ) {

        CollectionType collectionType = null;

        if(genericParameterType instanceof ParameterizedType){

            ParameterizedType aType = (ParameterizedType) genericParameterType;
            Type[] parameterArgTypes = aType.getActualTypeArguments();
            for ( Type parameterArgType : parameterArgTypes ) {
                collectionType = mapper.getTypeFactory().constructCollectionType(List.class, (Class<?>) parameterArgType ) ;
                break;
            }
        }

        return collectionType;      
    }