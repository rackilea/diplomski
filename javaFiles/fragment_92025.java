import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.AccessToken;
import  com.google.common.collect.Lists;

import java.io.FileInputStream;
import java.io.IOException;

class Main
{
    public static void main(String args[])
    {
    String  sa_file = "/fullpath/serviceaccount.json";
    String  scopes = "https://www.googleapis.com/auth/cloud-platform";

        GoogleCredentials credentials;

        try {
            credentials = GoogleCredentials.fromStream(new FileInputStream(sa_file))
                .createScoped(Lists.newArrayList(scopes));
        }
        catch (java.io.FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            return;
        }
        catch (IOException e) {
            System.out.println("IOException");
            return;
        }

        try {
            AccessToken accessToken;

            accessToken = credentials.getAccessToken();

            if (accessToken == null) {
                accessToken = credentials.refreshAccessToken();
            }

            if (accessToken != null) {
                System.out.println("Access Token: " + accessToken.getTokenValue());
            }
        }
        catch (IOException e) {
            System.out.println("IOException");
            return;
        }
    }
}