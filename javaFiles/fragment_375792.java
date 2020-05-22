public class MyInAppPurchaseBilling {

            private TinyDB tinyDB;    
            Activity activity;

            public MyInAppPurchaseBilling(Activity launcher) {
                this.activity = launcher;
            }

            public void onCreate() {
                tinyDB= new TinyDB(activity);
    }
}