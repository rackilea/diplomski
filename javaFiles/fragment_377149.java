public boolean tryCast(String value){
    for(Object o : enumClass.getEnumConstants()) {
        Enum<?> e = (Enum<?>) o;
        if(e.name().equals(value))
            return true;
    }
    return false;
}