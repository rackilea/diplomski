public class MyValue {
    enum Type {
       INT, STRING, BOOL;
    }
    private Type type; //Store the type of Object in Type Enum
    private Object value; //Store the value in Object

    public void setValue(int val) {
       type = Type.INT;
       value = new Integer(val);
    }
    public void setValue(String val) {
       type = Type.STRING;
       value = val;
    }
    public void setValue(boolean val) {
       type = Type.BOOL;
       value = new Boolean(val);
    }

    public String stringVal() {
        // check type to be STRING first
        return (String) value;
    }
    public int intVal() {
        // check type to be INT first
        return ((Integer) value.intValue());
    }
    public boolean booleanVal() {
        // check type to be BOOL first
        return ((Boolean) value.booleanValue());
    }
}