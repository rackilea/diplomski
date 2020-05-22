//private static ThreadLocal<MustacheSession> session_ = new ThreadLocal<MustacheSession>();
    private static MustacheSession _session = null;
    public static MustacheSession session(){
    //return session_.get();
    return _session;
    }
    public void onConfigurationRead(){
    // some code
    _session = new MustacheSession(compiler, root);
    // some code
    }