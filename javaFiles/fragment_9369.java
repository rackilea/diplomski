public static boolean listContains(List<?> source, String field, String value) {
    for (Object obj : source ) {
        try {
            Field f = obj.getClass().getDeclaredField(field); //get the field using name
            f.setAccessible(true);
            Object val = f.get(obj); //the value of the field in the current object
            if(value.equals(val)) { //if it equals to passed value
                return true;        //return true
            }
        } catch (NoSuchFieldException e) { //if the object doesn't have the field
            return false;                  //return false
        } catch (Exception e) { //their are other exceptions
            throw new RuntimeException(e); //how ever you want to handle
        }
    }
    return false; 
}