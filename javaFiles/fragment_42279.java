@Override
public void onCreate() {
  super.onCreate();
  if(instance != null)
     instance = MultiPraticApp.this;
  if(helper != null)
     helper = new MultiPraticAppHelper();

}