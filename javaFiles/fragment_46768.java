@JsonCreator
public static DefaultSortableField fromCode(final String code) {
    for(String key : cmap.keySet()){
        if(code.equalsIgnoreCase(key)){
            return cmap.get(key);
        }
    }
    return null;
}