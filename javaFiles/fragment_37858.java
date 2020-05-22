public String getKey(){
    return getPropertyValueOrNull("key");
}

public String getSecret(){
    return getPropertyValueOrNull("secret");
}

private String getPropertyValueOrNull(String property){
    String value = properties.getProperty(property);
    if (value == null || value.isEmpty()){
        return null;
    }
    return value;  
}