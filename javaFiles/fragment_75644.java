private static final String UA_STRING = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1";
private static final String REFRESH_URL = "refresh-url";
private String loginFormUrl = "http://www.registru.liceu.asm.md/elev/login.php?user=Vozian_Valentin";

// Go to login form page
Response res = Jsoup.connect(loginFormUrl) //
                    .userAgent(UA_STRING) //
                    .data("pass", "DyXnyU") //
                    .data("class","Clasa11B") //
                    .data("submit","log in") //
                    .method(Method.POST) //
                    .execute();

// Extract the Refresh meta tag from server response
Element meta = res.parse().select("meta[http-equiv=Refresh]").first();
if (meta==null) {
    throw new RuntimeException("Unable to locate Refresh meta tag...");
}

// Determine the refresh url from the meta tag
String content = meta.attr("content");
meta.attr(REFRESH_URL, content.replaceAll("(?i)^(\\d+;.+URL=)(.+)$", "$2"));

// Go to refresh url
Response res2 = Jsoup //
  .connect(meta.absUrl(REFRESH_URL)) //
  .userAgent(UA_STRING) // 
  .referrer(loginFormUrl) //
  .method(Method.GET) //
  .cookies(res.cookies()) //
  .execute();

// Get the successfully logged page
System.out.println(res2.parse().outerHtml());