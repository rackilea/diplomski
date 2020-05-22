public String serializeValue(Object ob) {
    if (ob == null) {
       return NULL_REPRESENTATION;
    } else if (ob.getClass() == String.class) {
       return ob.toString();
    } else if (ob.getClass() == Integer.class) {
       return ob.toString();
    } else if (ob instanceof List) {
       return serializeArray( ((List)ob).toArray());
    } ...
    else {
       return serializeFieldsWithReflection(ob);
    }
}