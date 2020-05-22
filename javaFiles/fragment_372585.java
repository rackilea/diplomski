public CentralServer getInstance() {
    if (_instance == null) {   // race condition possible here 
        _instance = new CentralServer();
    }
    return _instance;
}