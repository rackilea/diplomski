public class FacebookRealtimeSubscriber
        {
            private AccessToken appAccessToken = null;
            private String appSecret = // your app secret
            private String userAccessToken = // access token for user that owns the page, generated using your app
            private String applicationId = // your application id
            private String callbackURL = "<your context root>/social/facebook/update";
            private String pageName = // page name you want to install app for
            private FacebookClient client = null;
            private final String subscribedAppsEdge = "/subscribed_apps";
            private final String appSubscriptions = "/subscriptions";
            private final String verifyToken = "AnyRandomVerifyToken";
            // below are all the fields that can be subscribed for page object
            private final String pageFields = "feed,ratings,name,picture,category,description,founded,company_overview,conversations,mission,products,general_info,location,hours,parking,public_transit,phone,email,website,attire,payment_options,culinary_team,general_manager,price_range,restaurant_services,restaurant_specialties,videos,release_date,genre,starring,screenplay_by,directed_by,produced_by,studio,awards,plot_outline,network,season,schedule,written_by,band_members,hometown,current_location,record_label,booking_agent,press_contact,artists_we_like,influences,band_interests,bio,affiliation,birthday,personal_info,personal_interests,members,built,features,mpg,checkins,productlists";

            public static void main(String[] args)
            {
                new FacebookRealtimeSubscriber().subscribe();
            }

            private void subscribe()
            {
                String pageAccessToken = "";
                String pageId = "";
                client = new DefaultFacebookClient(Version.VERSION_2_3);
                appAccessToken = client.obtainAppAccessToken(applicationId, appSecret);
                client = new DefaultFacebookClient(userAccessToken, Version.VERSION_2_3);
                Connection<Account> pages = client.fetchConnection("me/accounts", Account.class);
                List<Account> accounts = pages.getData();
                for (Account account : accounts)
                {
                    if (pageName.equals(account.getName()))
                    {
                        pageAccessToken = account.getAccessToken();
                        pageId = account.getId();
                    }
                }
                client = new DefaultFacebookClient(pageAccessToken, appSecret, Version.VERSION_2_3);
                // subscribe app for page
                Object obj = client.publish(pageId + subscribedAppsEdge, JsonObject.class, Parameter.with("id", Long.valueOf(pageId)));
                System.out.println(obj.toString());
                // list subscriptions for app
                obj = client.fetchObject(pageId + subscribedAppsEdge, JsonObject.class);
                System.out.println(obj.toString());
                // subscribe for page updates for app
                client = new DefaultFacebookClient(appAccessToken.getAccessToken(), appSecret, Version.VERSION_2_3);
                obj = client.publish(applicationId + appSubscriptions,
                JsonObject.class,
                Parameter.with("object", "page"),
                Parameter.with("callback_url", callbackURL),
                Parameter.with("fields", pageFields),
                Parameter.with("verify_token", verifyToken));
                System.out.println(obj);
                // get subscriptions for app
                obj = client.fetchObject(applicationId + appSubscriptions, JsonObject.class);
                System.out.println(obj);
            }
        }