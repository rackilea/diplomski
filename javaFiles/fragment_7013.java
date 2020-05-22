public class MyApp extends Application {

            private static MyApp app;
            public static Instagram instaObject;

            @Override
            public void onCreate() {
                super.onCreate();
                app = this;


            }

            public static MyApp getApp() {
                return app;
            }

         public static void setInstagramObject(Instagram instaObject) {
                this.instaObject = instaObject;
            }

     public static Instagram getInstagramObject() {
                return instaObject;
            }

        }