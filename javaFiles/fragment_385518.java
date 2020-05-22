@Override
public void onCreate() {
    super.onCreate();

    //Code from MyApplication.java

    mInstance = this;
    pref = new PrefManager(this);
}