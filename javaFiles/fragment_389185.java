public static Connection getInstance() {
        if (instance==null){
            instance = new CreateConnection();
        }
        Constants.setFlag(true);
        return instance;
    }