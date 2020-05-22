package my.pkg.type;

public class NullNanFloatType implements UserType {

    public int[] sqlTypes() {
        return new int[]{Types.FLOAT};
    }

    public Class returnedClass() {
        return Float.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return ( x == y ) || ( x != null && x.equals( y ) );
    }

    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
        float value = rs.getFloat(names[0]);
        if (rs.wasNull()) {
            value = Float.NaN;
        }
        return new Float(value);
    }

    public void nullSafeSet(PreparedStatement ps, Object value, int index) throws HibernateException, SQLException {
        if (value == null || Float.isNaN(((Float)value).floatValue())) {
            ps.setNull(index, Types.FLOAT);
        } else {
            ps.setFloat(index, ((Float)value).floatValue());
        }
    }

    public Object deepCopy(Object value) throws HibernateException {
        //returning value should be OK since floats are immutable
        return value;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}