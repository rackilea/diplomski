public class VimeoServiceConcept {

public static void main(String[] args) {

    String apikey="api key";
    String apisecret="secret";
    String accessToken="access token";
    String accessTokenSecret="access token secret";

    OAuthService service = new ServiceBuilder().provider(VimeoApi.class).apiKey(apiKey).apiSecret(apiSecret).build();

    OAuthRequest request;
    Response response;

    accessToken = new Token("your_token", "your_tokens_secret");

    accessToken = checkToken(vimeoAPIURL, accessToken, service);
    if (accessToken == null) {
      return;
    }

    // Get Quota
    request = new OAuthRequest(Verb.GET, vimeoAPIURL);
    request.addQuerystringParameter("method", "vimeo.videos.upload.getQuota");
    signAndSendToVimeo(request, "getQuota", true);

    // Get Ticket
    request = new OAuthRequest(Verb.GET, vimeoAPIURL);
    request.addQuerystringParameter("method", "vimeo.videos.upload.getTicket");
    request.addQuerystringParameter("upload_method", "streaming");
    response = signAndSendToVimeo(request, "getTicket", true);
    //... the rest of your code...

   }
}