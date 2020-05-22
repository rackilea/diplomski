public class CustomIdGenerator implements IdentifierGenerator {

    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        String prefix = getIdPrefix();
        Connection connection = session.connection();
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('ASSET_SEQ') as nextval"); // could be different, depending on database vendor

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix + id;
                return code;
            }

        } catch (SQLException e) {
            throw new HibernateException(
                    "Unable to generate ID");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Throwable e) {
                    // log error, or rethrow exception
                }
            }
        }
        return null;
    }

    private String getIdPrefix() {
        DateFormat df = new SimpleDateFormat("YYYYMM");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

}

@Id
@GenericGenerator(name="seq_id", strategy="my.package.CustomIdGenerator")
@GeneratedValue(generator="seq_id")
// don't put that @Transient here
private long id;