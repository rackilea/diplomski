public  class JacksonUserType implements UserType {

    private static final int[] SQL_TYPES = { Types.LONGVARCHAR };

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        } else if (x == null || y == null) {
            return false;
        } else {
            return x.equals(y);
        }
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return null == x ? 0 : x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setString(index, null);
        } else {
            st.setString(index, convertObjectToJson(value));
        }
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        String content = rs.getString(names[0]);
        if(content!=null){
            return convertJsonToObject(content);
        }
        return null;
    }

    Object convertJsonToObject(String content){
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType type = createJavaType(mapper);
            return mapper.readValue(content, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String convertObjectToJson(Object object){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        String json = convertObjectToJson(value);
        return convertJsonToObject(json);
    }

    /**
     * Optionnal
     */
    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return deepCopy(original);
    }

    /**
     * (optional operation)
     *
     * @param value
     *
     * @throws HibernateException
     */
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    /**
     * (optional operation)
     *
     * @param cached
     * @param owner
     *
     * @return the instance cached
     *
     * @throws HibernateException
     */
    @Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return deepCopy(cached);
    }

    /**
     * By default we are expecting to use a simple object / not a collection (Set, List)
     *
     * @param mapper : instance jackson object mapper
     *
     * @return A jackson JavaType to specify wich object represent the json string representation
     *
     */
    public JavaType createJavaType (ObjectMapper mapper){
        return SimpleType.construct(returnedClass());
    }


    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return Object.class;
    }
}