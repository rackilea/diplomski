public static synchronized Manager getInstance()
    {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }