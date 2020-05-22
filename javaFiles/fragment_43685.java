@Override
public String convertToString(Map context, Object value) {
    try {            
        return new String((byte[]) value, "UTF-8");
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}