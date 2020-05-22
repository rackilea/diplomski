public class MyEnumConverter implements UserType {

    private static final int[] SQL_TYPES = new int[]{Types.OTHER};

    public Object nullSafeGet(ResultSet arg0, String[] arg1, Object arg2) throws HibernateException, SQLException {

        Object pgObject = arg0.getObject(X); // X is the column containing the enum

        try {
            Method valueMethod = pgObject.getClass().getMethod("getValue");
            String value = (String)valueMethod.invoke(pgObject);            
            return Mood.valueOf(value);     
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int[] sqlTypes() {       
        return SQL_TYPES;
    }

    // Rest of methods omitted

}