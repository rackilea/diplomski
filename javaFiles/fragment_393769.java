OnLogin(String value)
     {
       UserInfo userInfo = Singleton.getInstance().getUserInfo();
       userInfo.setValue(value);
       userInfo.notifyObserver();
     }