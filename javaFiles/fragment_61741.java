Uri uri = Uri.parse("https://graph.facebook.com/me/home?limit=25&since=1374196005");
String protocol = uri.getScheme();
String server = uri.getAuthority();
String path = uri.getPath();
Set<String> args = uri.getQueryParameterNames();
String limit = uri.getQueryParameter("limit");