private static ComboPooledDataSource createDataSource(String db, String user, String pass) {
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    cpds.setJdbcUrl("jdbc:mysql://X.X.X.X:3306/"+db);
    cpds.setUser(user);
    cpds.setPassword(pass);

    // Optional Settings
    cpds.setInitialPoolSize(5);
    cpds.setMinPoolSize(5);
    cpds.setAcquireIncrement(5);
    cpds.setMaxPoolSize(20);
    cpds.setMaxStatements(100);

    return cpds;
}

private static final class DbUserPassword {
    final String db;
    final String user;
    final String password;

    DbUserPassword( String db, String user, String password ) {
        this.db = db;
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals( Object o ) {
        if ( o instanceof DbUserPassword ) {
            DbUserPassword that = (DbUserPassword) o;
            return ( this.db.equals( that.db ) && this.user.equals( that.user ) && this.password.equals( that.password ) );
        }
        else {
            return false;
        }
}

    @Override
    public int hashCode() {
        return db.hashCode() ^ user.hashCode() ^ password.hashCode();
    }

}

// MT: protected by class' lock
private static HashMap<DbUserPassword,ComboPooledDataSource> poolMap = new HashMap<>();

public static synchronized ComboPooledDataSource getDataSource(String db, String user, String pass) {
    DbUserPassword dbup = new DbUserPassword( db, user, pass );
    ComboPooledDataSource out = poolMap.get(dbup);
    if ( out == null ) {
        out = createDataSource( db, user, pass );
        poolMap.put( dbup, out );
    }
    return out;
}