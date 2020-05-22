class App extends Application {

    @Override
    public void onCreate() {
        Realm.init(acti);
        RealmConfiguration otherConfig = new RealmConfiguration.Builder().directory(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/xMapper/"+fileN)).build();
        Realm.setDefaultConfiguration(otherConfig);
    }
}