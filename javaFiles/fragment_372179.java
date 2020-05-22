public interface Os<A extends App> {
   List<A> getApps(); 
   void installApps(Collection<A> apps);
}

public class Android implements Os<AndroidApp> {
    private ArrayList<AndroidApp> androidApps;

    @Override
    public void installApps(Collection<AndroidApp> apps) {
        for (AndroidApp app : apps) {
            System.out.println("installing android app ... "   +app.getAppName()+" installed!");
            androidApps.add(app);
        }
    }
}