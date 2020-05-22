public Object get(ResultSet rs, String name) throws HibernateException, SQLException {

    Timestamp ts = rs.getTimestamp(name);
    if (ts!=null) {
        Calendar cal = new GregorianCalendar();
        if ( Environment.jvmHasTimestampBug() ) {
            cal.setTime( new Date( ts.getTime() + ts.getNanos() / 1000000 ) );
        }
        else {
            cal.setTime(ts);
        }
        return cal;
    }
    else {
        return null;
    }

}