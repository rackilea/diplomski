@SuppressWarnings("unchecked")
public static <T> ArrayList<T> function(Class<T> type){
    if(type == String.class)
        return (ArrayList<T>) forString();
    return forGeneric(type);
}