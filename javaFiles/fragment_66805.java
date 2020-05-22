import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;

public class LITestActivity extends Activity {


    public static final String CONSUMER_KEY = "xx";
    public static final String CONSUMER_SECRET = "xx";
    private final static String APP_PNAME = "xx";


    public static final String APP_NAME = "xx;
    public static final String OAUTH_CALLBACK_SCHEME = "xx";
    public static final String OAUTH_CALLBACK_HOST = "xxx";
    public static final String OAUTH_CALLBACK_URL = OAUTH_CALLBACK_SCHEME
            + "://" + OAUTH_CALLBACK_HOST;

    final LinkedInOAuthService oAuthService = LinkedInOAuthServiceFactory
            .getInstance().createLinkedInOAuthService(CONSUMER_KEY,
                    CONSUMER_SECRET);
    final LinkedInApiClientFactory factory = LinkedInApiClientFactory
            .newInstance(CONSUMER_KEY, CONSUMER_SECRET);
    LinkedInRequestToken liToken;
    LinkedInApiClient client;

//  TextView tv = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //  setContentView(R.layout.main);
    //  tv = (TextView) findViewById(R.id.tv);
        try
        {
        liToken = oAuthService.getOAuthRequestToken(OAUTH_CALLBACK_URL);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(liToken
                .getAuthorizationUrl()));
        startActivity(i);
        }catch (Exception e) {
            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        String verifier = intent.getData().getQueryParameter("oauth_verifier");
        try{
        LinkedInAccessToken accessToken = oAuthService.getOAuthAccessToken(
                liToken, verifier);
        client = factory.createLinkedInApiClient(accessToken);
        String tweet = "Download Android App " + "market://details?id=" + APP_PNAME;
        client.postNetworkUpdate(tweet);
        //Person p = client.getProfileForCurrentUser();
        //tv.setText(p.getLastName() + ", " + p.getFirstName());
    //      p.setCurrentStatus("tweet");

        }catch (Exception e) {
            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
        finish();

    }
}