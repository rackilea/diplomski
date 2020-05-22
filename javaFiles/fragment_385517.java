@Override
public void onCreate() {
    super.onCreate();
    mInstance = this;
    pref = new PrefManager(this);
}