public class OoVarcharTypeDescriptor extends VarcharTypeDescriptor {
protected static final Logger log = LoggerFactory.getLogger(OoVarcharTypeDescriptor.class.getName());
public static final OoVarcharTypeDescriptor INSTANCE = new OoVarcharTypeDescriptor();
public static final String TRUNCATED_PARAMETER = "truncated parameter [%s] as [%s] - [%s]";
public static final char PERCENTAGE_CHAR = '%';

public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
    return new BasicBinder<X>(javaTypeDescriptor, this) {
        protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options) throws SQLException {
            FBParameterMetaData parameterMetaData = (FBParameterMetaData) st.getParameterMetaData();
            int precision = parameterMetaData.getPrecision(index);
            String unwrappedValue = javaTypeDescriptor.unwrap(value, String.class, options);
            if (unwrappedValue.charAt(0) == PERCENTAGE_CHAR && unwrappedValue.charAt(unwrappedValue.length() - 1) == PERCENTAGE_CHAR) {
                String coreValue = unwrappedValue.substring(1, unwrappedValue.length() - 1);
                if (coreValue.length() > precision) {
                    unwrappedValue = PERCENTAGE_CHAR + coreValue.substring(0, precision - 2) + PERCENTAGE_CHAR;
                    log.info(String.format(TRUNCATED_PARAMETER, index, JdbcTypeNameMapper.getTypeName(this.getSqlDescriptor().getSqlType()), unwrappedValue));
                }
            } else if (unwrappedValue.length() > precision) {
                unwrappedValue = unwrappedValue.substring(0, precision);
                log.info(String.format(TRUNCATED_PARAMETER, index, JdbcTypeNameMapper.getTypeName(this.getSqlDescriptor().getSqlType()), unwrappedValue));
            }

            st.setString(index, unwrappedValue);
        }

        protected void doBind(CallableStatement st, X value, String name, WrapperOptions options) throws SQLException {
            st.setString(name, (String) javaTypeDescriptor.unwrap(value, String.class, options));
        }
    };
}}