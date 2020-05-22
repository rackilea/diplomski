public class UtilDateUserType extends TimestampType{

    @Override
    public Object get(ResultSet rs, String name) throws SQLException {
        Timestamp ts = rs.getTimestamp(name);

        Date result = null;
        if(ts != null){
            result = new Date(ts.getTime());
        }

        return result;
    }
}