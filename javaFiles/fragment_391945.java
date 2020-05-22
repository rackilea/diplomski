public static synchronized Singletone getInstance() {
    if(instance == null){
        createInstance();
    }
    return instance;
}