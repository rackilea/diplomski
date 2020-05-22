public class UnixTimestampTypeDescriptor implements SqlTypeDescriptor {
    private static final long serialVersionUID = 1L;
    public static final UnixTimestampTypeDescriptor INSTANCE = new UnixTimestampTypeDescriptor();

    @Override
    public int getSqlType() {
        return Types.INTEGER;
    }

    @Override
    public boolean canBeRemapped() {
        return true;
    }

    @Override
    public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicBinder<X>(javaTypeDescriptor, this) {
            @Override
            protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options) throws SQLException {
                Date date = javaTypeDescriptor.unwrap(value, Date.class, options);
                date.setTime(date.getTime() / 1000);
                st.setDate(index, date);
            }
        };
    }

    @Override
    public <X> ValueExtractor<X> getExtractor(final JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicExtractor<X>(javaTypeDescriptor, this) {
            @Override
            protected X doExtract(ResultSet rs, String name, WrapperOptions options) throws SQLException {
                Date date = new Date(rs.getLong(name) * 1000);
                return javaTypeDescriptor.wrap(date, options);
            }
        };
    }
}