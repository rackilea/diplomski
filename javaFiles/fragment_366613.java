while token != EOF
    while token != FIELD_NAME
        nextToken()

    fieldName = nextFieldName();
    clazz = convertToClass(fieldName);
    vehicles.add(read(clazz));