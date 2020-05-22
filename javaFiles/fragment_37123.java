//In the Application subclass:
static MyApplication instance;
onCreate(){
    super.onCreate();
    instance = this;
}
public static final MyApplication getInstance(){
    return instance;
}