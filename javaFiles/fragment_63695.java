// ...
    for(Field field : Field.values()) {
        if (field.parseIndex >= loggedSensors.length) {
            // MySQL permits setting null like this, other DBs may
            // require #setNull(int, int)
            stmt.setObject(field.ordinal()+1, null); 
        else
            stmt.setObject(
                field.ordinal()+1, 
                field.parse(loggedSensors[field.parseIndex]));
    }
// ...