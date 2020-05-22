int oauth = content.indexOf(Const.OAUTH_TOKEN_SECRET);
if (oauth != -1) {
  int start = oath + Const.OATH_TOKEN_SECRET.length(); // or
  //int start = content.indexOf('=', oath) + 1;
  int end = content.indexOf('&', start);
  String tokenSecret = end == -1 ? content.substring(start) : content.substring(start, end);
}