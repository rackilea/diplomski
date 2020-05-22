GsonBuilder gsonBuilder = new GsonBuilder();
        // Allowing the serialization of static fields
    gsonBuilder.excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT);
    // Creates a Gson instance based on the current configuration
        Gson gson = gsonBuilder.create();
        Errors errorsInstance = Errors.getErrorsInstance();
        String jsonStringTest = gson.toJson(errorsInstance );