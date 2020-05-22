public static MySingleton getInstance() {
    if (_instance==null) {
        _instance = new MySingleton();
    }
    else return _instance;
}