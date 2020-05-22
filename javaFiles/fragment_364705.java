public class Session
{
    private static DbUtil; // static DBUtil

    protected Session() {
        //
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void initDBUtil(Context ctx){
        util = new DbUtil(ctx);
    }

    public DbUtil getDbUtil()
    {
      return util;
    }

}