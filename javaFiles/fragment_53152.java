String packageName = "com.facebook.katana";

String data = Jsoup.connect("https://apps.evozi.com/apk-downloader")
        .userAgent("Mozilla")
        .execute().body();

String token = "";
String time = "";

Pattern varPattern = Pattern.compile("dedbadfbadc:\\s+(\\w+),");
Pattern timePattern = Pattern.compile("t:\\s+(\\w+),");

Matcher varMatch = varPattern.matcher(data);
Matcher timeMatch = timePattern.matcher(data);

if (varMatch.find()) {
    Pattern tokenPattern = Pattern.compile("\\s*var\\s*" + varMatch.group(1) + "\\s*=\\s*'(.*)'.*");
    Matcher tokenMatch = tokenPattern.matcher(data);

    if (tokenMatch.find()) {
        token = tokenMatch.group(1);
    }
}

if (timeMatch.find()) {
    time = timeMatch.group(1);
}

HttpClient httpclient = HttpClients.createDefault();
HttpPost httppost = new HttpPost("https://api-apk.evozi.com/download");

List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("t", time));
params.add(new BasicNameValuePair("afedcfdcbdedcafe", packageName));
params.add(new BasicNameValuePair("dedbadfbadc", token));
params.add(new BasicNameValuePair("fetch", "false"));
httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

HttpResponse response = httpclient.execute(httppost);

JsonElement element = new JsonParser().parse(EntityUtils.toString(response.getEntity()));
JsonObject result = element.getAsJsonObject();

if (result.has("version") && result.has("version_code")) {
    System.out.println("version name : " + result.get("version").getAsString());
    System.out.println("version code : " + result.get("version_code").getAsInt());
} else {
    System.out.println(result);
}