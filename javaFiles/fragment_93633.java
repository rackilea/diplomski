static final String URL = "http://csddata.site11.com/dynamic.php?cat=%s";

Intent i = getIntent();
String title = i.getStringExtra("title");

String finalUrl = String.format(URL,title);