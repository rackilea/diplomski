import android.os.AsyncTask;      
import android.webkit.WebView;
import android.webkit.WebViewClient;    
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Use a WebView to login in to Google Account and specific username within it.
 */
public class AuthenticateWebView {

    LoginActivity activity;
    String authToken = ApplicationConstants.emptyString;
    HttpTransport httpTransport = new NetHttpTransport();
    JsonFactory jacksonFactory = new JacksonFactory();
    WebView authWebView;

    AuthenticateWebView(LoginActivity activity) {
        this.activity= activity;
    }


    private void loadLayout(){
        activity.setContentView(R.layout.authentication_web_view);
        authWebView = (WebView) activity.findViewById(R.id.authWebView);
    }

    protected void loadWebView(){
        loadLayout();
        authWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);               
                if (url.contains("https://accounts.google.com/o/oauth2/approval")){
                    activity.setContentView(R.layout.activity_main);                    
                    searchForCodeOrError(authWebView.getTitle());
                }
            }
        });
        authWebView.getSettings().setJavaScriptEnabled(true);
        authWebView.loadUrl("https://accounts.google.com/o/oauth2/auth?client_id="+      ApplicationConstants.CLIENT_ID+ 
                            "&redirect_uri="+ ApplicationConstants.REDIRECT_URI+ 
                            "&response_type="+ ApplicationConstants.RESPONSE_TYPE);
    }

    private void requestAccessToken(String authToken){
        final String requestToken = authToken;
        try{
            new AsyncTask<String, Void, GoogleTokenResponse>(){
                    GoogleTokenResponse response = null;
                    @Override
                    public GoogleTokenResponse doInBackground(String... params){
                        try {
                            response = new GoogleAuthorizationCodeTokenRequest(httpTransport, jacksonFactory, ApplicationConstants.CLIENT_ID
                                , ApplicationConstants.CLIENT_SECRET, params[0], ApplicationConstants.REDIRECT_URI).execute();
                        } catch (IOException e1) {
                            //catches TokenResponseException                            
                            requestAccessToken(requestToken);
                        }
                        return response;
                    }
                    @Override
                    public void onPostExecute(GoogleTokenResponse response1){
                        activity.currentAccessToken = response1.getAccessToken();
                        if (activity.currentAccessToken != null){
                            activity.mToken = activity.currentAccessToken;
                            activity.loadListHeaderandFooter();
                            activity.loadData();
                        }
                   }
            }.execute(authToken);
        }catch (Exception e){
                Log.e("Error occured in AuthenticateWebview.requestAccessToken()", e.getMessage());
        }
    }


   private void searchForCodeOrError(String pageTitle){        
        if (pageTitle.contains("code=") | pageTitle.contains("error=")){
           ArrayList<Character> charList = new ArrayList<Character>();            
            for (char c: pageTitle.toCharArray()){
                charList.add(c);
                if (charList.contains("code=") | charList.contains("error=")){
                    charList.clear();
                }
            }

           for (char c: charList){
               authToken += c;
           }
           authToken = authToken.substring(13);        
           requestAccessToken(authToken);

        }
    }
}