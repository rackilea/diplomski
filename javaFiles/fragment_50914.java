class MyHashMap extends HashMap {
    @Override
    public Object put(Object key, Object value) {
        String strKey = (String)key;
        String strValue = (String)value;
        super.put(strKey + ":lower", strValue.toLowerCase());
        super.put(strKey + ":upper", strValue.toUpperCase());
        return strKey;
    }
}