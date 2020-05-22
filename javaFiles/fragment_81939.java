package com.bitplan.resthelper;
import java.lang.reflect.Field;

/**
 * Reflection help
 * @author wf
 *
 */
public class FieldHelper {

    /**
     * get a Field including superclasses
     * 
     * @param c
     * @param fieldName
     * @return
     */
    public Field getField(Class<?> c, String fieldName) {
        Field result = null;
        try {
            result = c.getDeclaredField(fieldName);
        } catch (NoSuchFieldException nsfe) {
            Class<?> sc = c.getSuperclass();
            result = getField(sc, fieldName);
        }
        return result;
    }

    /**
     * set a field Value by name
     * 
     * @param fieldName
     * @param Value
     * @throws Exception
     */
    public void setFieldValue(Object target,String fieldName, Object value) throws Exception {
        Class<? extends Object> c = target.getClass();
        Field field = getField(c, fieldName);
        field.setAccessible(true);
        // beware of ...
        // http://docs.oracle.com/javase/tutorial/reflect/member/fieldTrouble.html
        field.set(this, value);
    }

    /**
     * get a field Value by name
     * 
     * @param fieldName
     * @return
     * @throws Exception
     */
    public Object getFieldValue(Object target,String fieldName) throws Exception {
        Class<? extends Object> c = target.getClass();
        Field field = getField(c, fieldName);
        field.setAccessible(true);
        Object result = field.get(target);
        return result;
    }

}