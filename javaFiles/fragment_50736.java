import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.analytics.Analytics;
import com.google.api.services.analytics.AnalyticsScopes;
import com.google.api.services.analytics.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple example of how to access the Google Analytics API.
 */
public class HelloAnalytics {
    // Path to client_secrets.json file downloaded from the Developer's Console.
    // The path is relative to HelloAnalytics.java.
    private static final String CLIENT_SECRET_JSON_RESOURCE = "/client_secret.json";
    // The directory where the user's credentials will be stored.
    private static final File DATA_STORE_DIR = new File("out/DataStore/hello_analytics");
    private static final File OUTPUT_FILE = new File("out/DataStore/output.text");

    private static final String APPLICATION_NAME = "Online Marketing Buddy";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static NetHttpTransport httpTransport;
    private static FileDataStoreFactory dataStoreFactory;

    public static void main(String[] args) {
        try {

            Analytics analytics = initializeAnalytics();
            getProfileIds(analytics);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Analytics initializeAnalytics() throws Exception {

        httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);

        // Load client secrets.
        InputStream in =
                HelloAnalytics.class.getResourceAsStream(CLIENT_SECRET_JSON_RESOURCE);
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Set up authorization code flow for all auth scopes.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow
                .Builder(httpTransport, JSON_FACTORY, clientSecrets,AnalyticsScopes.all())
                .setDataStoreFactory(dataStoreFactory)
                .build();

        // Authorize.
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
                .authorize("user");

        // Construct the Analytics service object.
        Analytics response = new Analytics
                .Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME).build();

        return response;
    }

    private static void getProfileIds(Analytics analytics) throws IOException {
        // Get the all view (profile) IDs for the authorized user.
        List<String> profileIds = new ArrayList<>();

        // Query for the list of all accounts associated with the service account.
        Accounts accounts = analytics.management().accounts().list().execute();

        if (accounts.getItems().isEmpty()) {
            System.err.println("No accounts found");
        } else {
            for (Account account : accounts.getItems()) {
                System.out.println("account: " + account.getName());
                String accountId = account.getId();

                // Query for the list of properties associated with the each account.
                Webproperties properties = analytics.management().webproperties()
                        .list(accountId).execute();

                if (properties.getItems().isEmpty()) {
                    System.err.println("No properties found for accountId: " + accountId);
                } else {
                    for (Webproperty webproperty : properties.getItems()) {
                        System.out.println("\nwebproperty: " + webproperty.getName());
                        String webpropertyId = webproperty.getId();

                        // Query for the list views (profiles) associated with the property.
                        Profiles profiles = analytics.management().profiles()
                                .list(accountId, webpropertyId).execute();

                        if (profiles.getItems().isEmpty()) {
                            System.err.println("No views (profiles) found for accoundId: " + accountId + "and webpropertyId: " + webpropertyId);
                        } else {
                            // Return the first (view) profile associated with the property.
                            for (Profile profile : profiles.getItems()) {
                                System.out.println("\nprofileId added for profile: " + profile.getName());
                                profileIds.add(profile.getId());
                                printResults(getResults(analytics,profile.getId()), profile.getId());
                            }
                        }
                        System.out.println("---------- ---------- end webproperty: " + webproperty.getName() + "---------- ----------");
                    }
                }
                System.out.println("---------- ---------- end account: " + account.getName() + "---------- ----------");
            }
        }
    }

    private static GaData getResults(Analytics analytics, String profileId) throws IOException {
        // Query the Core Reporting API for the number of sessions
        // in the past 30 days.
        GaData data = analytics.data().ga()
                .get("ga:" + profileId, "30daysAgo", "yesterday", "ga:adClicks, ga:adCost, ga:transactions, ga:transactionRevenue, ga:users, ga:sessions")
                .setDimensions("ga:adwordsCampaignID")
                .execute();
        return data;
    }

    private static void printResults(GaData results, String profile) {
        // Parse the response from the Core Reporting API for
        // the profile name and number of sessions.
        if (null != results) {
            System.out.println("View (Profile: " + profile + ") Name: "
                    + results.getProfileInfo().getProfileName() + "\n");
            if (results.get("rows") != null && results.get("columnHeaders") != null) {
                if (!results.getRows().isEmpty() && !results.getColumnHeaders().isEmpty()) {
                    for (List<String> row : results.getRows()) {
                        for (int i=0; i<results.getColumnHeaders().size();i++) {
                            List<GaData.ColumnHeaders> headers = results.getColumnHeaders();
                            System.out.println( headers.get(i).getName()+": " + row.get(i) + "\n");
                        }
                        System.out.println("---------- ---------- ----------\n");
                    }
                } else {
                    System.out.println("No rows or columHeaders empty\n");
                }
            } else {
                System.out.println("No rows or columHeaders\n");
            }
        }
    }
}